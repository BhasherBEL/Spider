package be.bhasher.spider.player;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;

import be.bhasher.spider.Spider;
import be.bhasher.spider.SpiderConfig;
import net.minecraft.server.v1_13_R2.v1_13_R2.MinecraftServer;

/**
 * Runnable of a {@link SpiderPlayer}. Performs cheat checks.
 */
public class PlayerRunnable implements Runnable{

	/**
	 * Ticks between two executions.
	 */
	public static final int 	TICK_RATE = 1;
	public static int tick = MinecraftServer.currentTick;
	public static int lastTick = tick;

	private int timeFromLastCheck = 0;

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

		if(timeFromLastCheck >= SpiderConfig.getCheckTime()/TICK_RATE*20){
			sp.speedHack.preventTest();
			timeFromLastCheck = 0;
		}

		tick = MinecraftServer.currentTick;

		// Player online
		if(!sp.getPlayer().isOnline()) {
			task.cancel();
		}
		sp.initStart();

		sp.speedHack.update();

		sp.lastLocation = sp.location;

		lastTick = tick;

		timeFromLastCheck++;

	}

}
