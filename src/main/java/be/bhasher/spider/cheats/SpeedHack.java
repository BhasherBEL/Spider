package be.bhasher.spider.cheats;

import org.bukkit.util.Vector;

import be.bhasher.spider.alerts.AlertType;
import be.bhasher.spider.player.PlayerRunnable;
import be.bhasher.spider.player.SpiderPlayer;
import be.bhasher.spider.utils.Format;
import be.bhasher.spider.utils.player.PlayerMove;

/**
 * Manages the speed hack check.
 */
public class SpeedHack {

	/**
	 * Performs speekhack verification.
	 * @param sp The {@link SpiderPlayer}.
	 */
	public SpeedHack(final SpiderPlayer sp){
		// Player has not moved.
		if(!sp.hasMoved()) {
			return;
		}

		// Player is flying or is riptiding or is gliding.
		if(sp.getPlayer().isFlying() || sp.getPlayer().isRiptiding() || sp.getPlayer().isGliding() || sp.getPlayer().getVehicle() != null){
			return;
		}

		final Vector move = sp.location.toVector().subtract(sp.lastLocation.toVector());

		// If move is only horizontal
		if(sp.groundTime > 0){

			final double horizontal_move = move.clone().setY(0).length();

			double max_horizontal_distance = PlayerMove.getHorizontalSpeed(sp.getPlayer())/20* PlayerRunnable.TICK_RATE;

			if(sp.groundTime <= 4){
				max_horizontal_distance *= 1.2;
			}

			final double ratio = (horizontal_move/max_horizontal_distance);

			if(ratio > 0.5){
				sp.speedhackScore += Math.max((ratio-1), 0)*PlayerRunnable.TICK_RATE;
				sp.speedhackScore -= 0.1*PlayerRunnable.TICK_RATE;
				if(sp.speedhackScore < 0) {
					sp.speedhackScore = 0;
				}
			}

			if(ratio > 1.01){

				sp.alert(AlertType.SPEEDHACK, "score: " + Format.round(sp.speedhackScore, 2) + ", ratio: " + Format.round(ratio*100,2) + "%");

			}

		}

	}

}
