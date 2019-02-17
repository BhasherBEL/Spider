package be.bhasher.spider.cheats.move;

import be.bhasher.spider.player.SpiderPlayer;
import be.bhasher.spider.utils.Time;

class MoveStartSet {

	/**
	 * Setter before the test.
	 * @param sp The {@link SpiderPlayer}.
	 */
	protected MoveStartSet(final SpiderPlayer sp){
		if(sp.getPlayer().isOnGround()) {
			sp.groundY = sp.location.getY();
			sp.groundTime = Time.getTimestamp();
		}

		sp.location = sp.getPlayer().getLocation();
		sp.speed = sp.getLocationClone().toVector().subtract(sp.getLastLocationClone().toVector()).multiply(20);
	}

}
