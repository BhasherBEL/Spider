package be.bhasher.spider.cheats;

import org.bukkit.util.Vector;

import be.bhasher.spider.SpiderConfig;
import be.bhasher.spider.alerts.AlertType;
import be.bhasher.spider.player.PlayerRunnable;
import be.bhasher.spider.player.SpiderPlayer;
import be.bhasher.spider.utils.Format;
import be.bhasher.spider.utils.player.PlayerMove;

public class SpeedHack {

	public SpeedHack(final SpiderPlayer sp){
		// Player has not moved.
		if(!sp.hasMoved()) {
			return;
		}

		// Player is flying or is riptiding or is gliding.
		if(sp.getPlayer().isFlying() || sp.getPlayer().isRiptiding() || sp.getPlayer().isGliding()){
			return;
		}

		final Vector move = sp.location.toVector().subtract(sp.lastLocation.toVector());
		final double horizontal_move = move.clone().setY(0).length();

		final double max_horizontal_distance = PlayerMove.getHorizontalSpeed(sp.getPlayer())/20* PlayerRunnable.TICK_RATE;

		if(horizontal_move > max_horizontal_distance* SpiderConfig.getTolerance()){
			sp.alert(AlertType.SPEEDHACK, Format.round(horizontal_move, 2) + ", " + Format.round((horizontal_move/max_horizontal_distance)*100, 2) + "%");
		}

	}

}
