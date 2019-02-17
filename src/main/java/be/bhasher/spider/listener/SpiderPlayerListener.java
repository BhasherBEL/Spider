package be.bhasher.spider.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import be.bhasher.spider.player.SpiderPlayer;

public class SpiderPlayerListener implements Listener {

	/**
	 * Init the SpiderPlayer when a {@link Player} connect.
	 * @param event a {@link PlayerJoinEvent}.
	 */
	@EventHandler
	public void onPlayerJoin(final PlayerJoinEvent event){
		SpiderPlayer.set(event.getPlayer());
	}

	/**
	 * Disable the {@link SpiderPlayer} when a {@link Player} disconnect.
	 * @param event a {@link PlayerQuitEvent}.
	 */
	@EventHandler
	public void onPlayerQuit(final PlayerQuitEvent event){
		SpiderPlayer.remove(event.getPlayer());
	}

}
