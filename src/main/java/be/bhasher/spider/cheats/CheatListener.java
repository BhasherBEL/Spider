package be.bhasher.spider.cheats;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import be.bhasher.spider.alerts.CheatLevel;
import be.bhasher.spider.player.SpiderPlayer;
import be.bhasher.spider.utils.player.PlayerPunishment;

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
		if(sp.speedHack.getLevel() == CheatLevel.CRITICAL){
			PlayerPunishment.autoBanPlayer(sp, "disconnecting when he was suspected of speedhacking");
		}
	}
}
