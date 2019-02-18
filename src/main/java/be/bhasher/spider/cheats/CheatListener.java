package be.bhasher.spider.cheats;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import be.bhasher.spider.alerts.AlertForce;
import be.bhasher.spider.player.SpiderPlayer;

/**
 * Event related to cheats
 */
public class CheatListener implements Listener {

	/**
	 * When a player disconnects, if his cheat level is critical, ban him.
	 * @param event a {@link PlayerQuitEvent}.
	 */
	@EventHandler
	public void onPlayerQuit(final PlayerQuitEvent event){
		final Player player = event.getPlayer();
		final SpiderPlayer sp = SpiderPlayer.get(player);
		if(sp.getSpeedHackForce() == AlertForce.CRITICAL){
			Bukkit.broadcastMessage("§c[§3Spider§c]§f " + player.getName() + " was banned for disconnecting when he was suspected of cheating.");
		}
	}

}
