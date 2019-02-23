package be.bhasher.spider.cheats;

import org.bukkit.util.Vector;

import be.bhasher.spider.player.SpiderPlayer;

public class NoVelocity {

	public NoVelocity(final SpiderPlayer sp){
		if(sp.velocity.length() > 0){
			if(!sp.hasMoved()){
				sp.getPlayer().sendMessage("No velocity ?");
			}
			sp.velocity = new Vector(0,0,0);
		}
	}

}
