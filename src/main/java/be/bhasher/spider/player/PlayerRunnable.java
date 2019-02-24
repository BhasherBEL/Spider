package be.bhasher.spider.player;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;

import be.bhasher.spider.Spider;
import be.bhasher.spider.cheats.SpeedHack;

/**
 * Runnable of a {@link SpiderPlayer}. Performs cheat checks.
 */
public class PlayerRunnable implements Runnable{

	/**
	 * Ticks between two executions.
	 */
	public static final int 	TICK_RATE = 5;

	private final SpiderPlayer	sp;
	private final BukkitTask	task;

	/**
	 * Initializes and starts the runnable and starts the checks.
	 * @param sp The {@link SpiderPlayer}.
	 */
	public PlayerRunnable(final SpiderPlayer sp){
		this.sp = sp;
		this.task = Bukkit.getScheduler().runTaskTimer(Spider.getInstance(), this, 0, TICK_RATE);
	}

	/**
	 * Performed every {@value TICK_RATE} ticks.
	 */
	@Override
	public void run() {

		// Player online
		if(!sp.getPlayer().isOnline()) {
			task.cancel();
		}

		sp.pd.setAll();

		sp.location = sp.getPlayer().getLocation();
		if(sp.getPlayer().isOnGround()){
			sp.groundY = sp.location.getY();
			sp.groundTime+=TICK_RATE;
		}else{
			if(sp.getPlayer().isFlying()){
				sp.groundTime = -20/TICK_RATE;
			}else if(sp.groundTime > 0){
				sp.groundTime = 0;
			}
		}

		if(sp.hasMoved()){
			sp.getPlayer().sendMessage(sp.pd.isInLiquid() ? "§2Oui" : "§cNon");
		}

		new SpeedHack(sp);

		sp.lastLocation = sp.location;

	}

}
