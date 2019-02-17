package be.bhasher.spider.player;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;

import be.bhasher.spider.Spider;
import be.bhasher.spider.cheats.SpeedHack;

public class PlayerRunnable implements Runnable{

	public static final int 	TICK_RATE = 1;
	private final SpiderPlayer	sp;
	private final BukkitTask	task;

	public PlayerRunnable(final SpiderPlayer sp){
		this.sp = sp;
		this.task = Bukkit.getScheduler().runTaskTimer(Spider.getInstance(), this, 0, TICK_RATE);
	}

	@Override
	public void run() {

		// Player online
		if(!sp.getPlayer().isOnline()) {
			task.cancel();
		}

		sp.location = sp.getPlayer().getLocation();
		if(sp.getPlayer().isOnGround()){
			sp.groundY = sp.location.getY();
		}

		new SpeedHack(sp);

		sp.lastLocation = sp.location;

	}

}
