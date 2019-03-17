package be.bhasher.spider.cheats;

import be.bhasher.spider.alerts.AlertType;
import be.bhasher.spider.player.PlayerRunnable;
import be.bhasher.spider.player.SpiderPlayer;
import be.bhasher.spider.utils.Format;
import be.bhasher.spider.utils.player.PlayerMove;
import be.bhasher.spider.utils.player.PlayerPunishment;

/**
 * Manages the speed hack check.
 */
public class SpeedHack extends Cheat {

	/**
	 * Performs speekhack verification.
	 * @param sp The {@link SpiderPlayer}.
	 */
	public SpeedHack(final SpiderPlayer sp){
		super(sp, AlertType.SPEEDHACK);

	}

	@Override
	protected boolean isBypass() {
		return sp.getPlayer().isFlying() || sp.getPlayer().isRiptiding() || sp.getPlayer().isGliding() || sp.getPlayer().getVehicle() != null;
	}

	@Override
	public void update() {
		super.update();

		// Player has not moved.
		if(!sp.hasMoved() || sp.getPlayer().isRiptiding()) {
			if(!sp.hasBeenStatic) {
				sp.hasBeenStatic = true;
			}
			return;
		}

		// If move is only horizontal
		if(sp.groundTime > 0){

			final double horizontal_move = sp.move.clone().setY(0).length();

			double max_horizontal_distance = PlayerMove.getHorizontalSpeed(sp.getPlayer())/20* PlayerRunnable.TICK_RATE;

			if(sp.groundTime <= 20){
				max_horizontal_distance *= 1.2;
			}

			double ratio = (horizontal_move/max_horizontal_distance);

			if(ratio > 1.02 && sp.hasBeenStatic){
				sp.hasBeenStatic = false;
				ratio /= 2 ;
			}

			if(ratio > 0.5){
				sp.speedhackScore += Math.min(Math.max((ratio-1), 0), 10)*PlayerRunnable.TICK_RATE;
				sp.speedhackScore -= 0.04* PlayerRunnable.TICK_RATE;
				if(sp.speedhackScore < 0) {
					sp.speedhackScore = 0;
				}
			}

			if(true){

				super.prevent(new Detection(AlertType.SPEEDHACK, sp.speedhackScore), (ratio > 1.01 ? "§c":"") + " Move: " + Format.round(horizontal_move*20/PlayerRunnable.TICK_RATE, 2) + ", tick passed: " + (PlayerRunnable.tick-PlayerRunnable.lastTick));

			}

			if(sp.speedhackScore > 5000){
				PlayerPunishment.autoBanPlayer(sp, "SpeedHack");
			}

		}
	}
}
