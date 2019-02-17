package be.bhasher.spider.cheats.move;

import be.bhasher.spider.player.SpiderPlayer;

class MoveEndSet {

	/**
	 * Setter after the test.
	 * @param sp
	 */
	protected MoveEndSet(final SpiderPlayer sp){

		if(!sp.getPlayer().isOnGround()){
			sp.airSpeed = sp.getLocationClone().toVector().subtract(sp.getLastLocationClone().toVector()).multiply(20);;
		}

		sp.lastLocation = sp.location;
		sp.lastSpeed = sp.speed;

		sp.situations.clear();
	}

}
