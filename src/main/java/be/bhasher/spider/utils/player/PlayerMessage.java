package be.bhasher.spider.utils.player;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import be.bhasher.spider.utils.permission.CustomPermission;

/**
 * Class managing messages to players.
 */
public class PlayerMessage {

	/**
	 * Send a message to all {@link Player} with the permission.
	 * @param permission The permission.
	 * @param message The message.
	 */
	public static void sendMessageWithPermission(final CustomPermission permission, final String message){
		for(final Player player : Bukkit.getOnlinePlayers()){
			if(player.hasPermission(permission.getPermission())) {
				player.sendMessage(message);
			}
		}
	}

	/**
	 * Send a message to all {@link Player}.
	 * @param message The message.
	 */
	public static void sendMessageToAll(final String message){
		for(final Player player : Bukkit.getOnlinePlayers()){
			player.sendMessage(message);
		}
	}

}
