package be.bhasher.spider.utils.player;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import be.bhasher.spider.SpiderPermission;

/**
 * Class managing messages to players.
 */
public class PlayerMessage {

	/**
	 * Send a message to all {@link Player} with the {@link SpiderPermission}.
	 * @param permission The {@link SpiderPermission}.
	 * @param message The message.
	 */
	public static void sendMessageWithPermission(final SpiderPermission permission, final String message){
		sendMessageWithPermission(permission.getPermission(), message);
	}

	/**
	 * Send a message to all {@link Player} with the permission.
	 * @param permission The permission.
	 * @param message The message.
	 */
	public static void sendMessageWithPermission(final String permission, final String message){
		for(final Player player : Bukkit.getOnlinePlayers()){
			if(player.hasPermission(permission)) {
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
