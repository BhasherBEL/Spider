package be.bhasher.spider.cheats;

import org.bukkit.entity.Player;

import be.bhasher.spider.player.SpiderPlayer;

public abstract class Cheats<P extends SpiderPlayer> {

	protected Player player;
	protected P spiderPlayer;

	public Cheats(final P spiderPlayer){
		this.spiderPlayer = spiderPlayer ;
		this.player = spiderPlayer.getPlayer();
	}

}
