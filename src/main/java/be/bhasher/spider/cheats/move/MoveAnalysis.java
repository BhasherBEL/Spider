package be.bhasher.spider.cheats.move;

import be.bhasher.spider.alerts.AlertType;
import be.bhasher.spider.player.SpiderPlayer;
import be.bhasher.spider.utils.Format;

public class MoveAnalysis {

	private final Double TOLERANCE = MoveRunnable.TOLERANCE;

	/**
	 * Analyzes and predicts the player's movement, and then verifies that the observed movement is possible.
	 * @param sp The {@link SpiderPlayer} for situations flags.
	 */
	public MoveAnalysis(final SpiderPlayer sp){

		final double horizontal_speed = sp.speed.clone().setY(0).length();

		if(sp.situations.contains(Situation.ON_GROUND)
			&& sp.situations.contains(Situation.WALK)){
			if(horizontal_speed > 4.3*TOLERANCE){
				sp.alert(AlertType.SPEEDHACK, Format.round(horizontal_speed, 2) + "m/s => " + Format.round(horizontal_speed/(4.3*TOLERANCE)*100, 2) + "%");
			}
		}

	}

}
