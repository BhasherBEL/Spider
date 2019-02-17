package be.bhasher.spider.cheats.move;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import be.bhasher.spider.Spider;
import be.bhasher.spider.SpiderConfig;
import be.bhasher.spider.player.SpiderPlayer;
import be.bhasher.spider.utils.player.PlayerMove;

public class MoveRunnable implements Runnable {

	public static final double TOLERANCE = SpiderConfig.getTolerance();

	private final SpiderPlayer sp;
	private final BukkitTask task;

	/**
	 * Init a move runnable for the {@link Player};
	 * @param player
	 */
	public MoveRunnable(final Player player){
		this.sp = SpiderPlayer.get(player);
		this.task = Bukkit.getScheduler().runTaskTimer(Spider.getPlugin(Spider.class), this, 0, 1);
	}

	/**
	 * Execute the move runnable.
	 */
	@Override
	public void run(){

		if(!sp.getPlayer().isOnline()) {
			task.cancel(); //Deprecated
		}

		if(PlayerMove.hasMoved(sp.lastLocation, sp.location)){
			new MoveStartSet(sp);
			new MoveDescription(sp);
			new MoveAnalysis(sp);
			new MoveEndSet(sp);
		}
	}

}
