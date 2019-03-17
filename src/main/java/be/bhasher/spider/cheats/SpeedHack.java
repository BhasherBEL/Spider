package be.bhasher.spider.cheats;

import be.bhasher.spider.alerts.CheatType;
import be.bhasher.spider.player.PlayerRunnable;
import be.bhasher.spider.player.SpiderPlayer;
import be.bhasher.spider.utils.player.PlayerMove;

/**
 * Manages the speed hack check.
 */
public class SpeedHack extends Cheat {

	public double groundY;
	public double groundTime;

	/**
	 * Performs speekhack verification.
	 * @param sp The {@link SpiderPlayer}.
	 */
	public SpeedHack(final SpiderPlayer sp){
		super(sp, CheatType.SPEEDHACK);

	}

	@Override
	protected boolean isBypass() {
		return sp.getPlayer().isFlying() || sp.getPlayer().isRiptiding() || sp.getPlayer().isGliding() || sp.getPlayer().getVehicle() != null;
	}

	@Override
	public void update() {
		super.update();

		if(sp.getPlayer().isOnGround()){
			groundY = sp.location.getY();
			groundTime+= PlayerRunnable.TICK_RATE;
		}else{
			if(sp.getPlayer().isFlying()){
				groundTime = Math.round(-20./PlayerRunnable.TICK_RATE);
			}else if(groundTime > 0){
				groundTime = 0;
			}
		}

		// Player has not moved.
		if(!sp.hasMoved() || sp.getPlayer().isRiptiding()) {
			if(!sp.hasBeenStatic) {
				sp.hasBeenStatic = true;
			}
			return;
		}

		// If move is only horizontal
		if(groundTime > 0){

			final double horizontal_move = sp.move.clone().setY(0).length();

			double max_horizontal_distance = PlayerMove.getHorizontalSpeed(sp.getPlayer())/20* PlayerRunnable.TICK_RATE;

			if(groundTime <= 20){
				max_horizontal_distance *= 1.2;
			}

			double ratio = (horizontal_move/max_horizontal_distance);

			if(ratio > 1.02 && sp.hasBeenStatic){
				sp.hasBeenStatic = false;
				ratio /= 2 ;
			}

			if(ratio > 0.5){
				score += Math.min(Math.max((ratio-1), 0), 10)*PlayerRunnable.TICK_RATE;
				score -= 0.04* PlayerRunnable.TICK_RATE;
				if(score < 0) {
					score = 0;
				}
			}

			if(ratio > 1.05){
				addDetection(new Detection(CheatType.SPEEDHACK, score));
			}

		}
	}
}
