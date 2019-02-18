package be.bhasher.spider.player;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import be.bhasher.spider.SpiderPermission;
import be.bhasher.spider.alerts.AlertForce;
import be.bhasher.spider.alerts.AlertType;
import be.bhasher.spider.utils.player.PlayerMessage;
import be.bhasher.spider.utils.player.PlayerMove;

/**
 * Additional information about a player grouped in a {@link SpiderPlayer} object.
 * They are listed in a {@link Map} depending on the {@link Player}.
 */
public class SpiderPlayer {

	/**
	 * Map of {@link SpiderPlayer} depending on the {@link Player}.
	 */
	private static final Map<Player, SpiderPlayer> spiderPlayers = new HashMap<>();

	private final Player player;

	public Location lastLocation;
	public Location location;
	public double groundY;
	public double speedhackScore=0;

	/**
	 * Initializes a new {@link SpiderPlayer}.
	 * @param player The {@link Player} to initialize.
	 */
	private SpiderPlayer(final Player player){
		this.player = player;
		this.lastLocation = player.getLocation();
	}

	/**
	 * Clear spiderPlayers and redefine the players' {@link SpiderPlayer}.
	 */
	public static void resetPlayers(){
		SpiderPlayer.clear();
		for(final Player player : Bukkit.getOnlinePlayers()){
			SpiderPlayer.init(player);
		}
	}

	/**
	 * Define a {@link SpiderPlayer}.
	 * @param player The {@link Player} to define.
	 */
	public static void init(final Player player){
		if(!spiderPlayers.containsKey(player)) {
			spiderPlayers.put(player, new SpiderPlayer(player));
			new PlayerRunnable(spiderPlayers.get(player));
		}
	}

	/**
	 * Get the {@link SpiderPlayer} associated with the {@link Player}.
	 * @param player The {@link Player} to get.
	 * @return the {@link SpiderPlayer}.
	 */
	public static SpiderPlayer get(final Player player){
		if(spiderPlayers.containsKey(player)) {
			return spiderPlayers.get(player) ;
		} else {
			final SpiderPlayer spiderPlayer = new SpiderPlayer(player) ;
			spiderPlayers.put(player, spiderPlayer);
			return spiderPlayer;
		}
	}

	/**
	 * Clear the spiderPlayers list.
	 */
	public static void clear(){
		spiderPlayers.clear();
	}

	/**
	 * Remove a {@link Player} in the spiderPlayers list.
	 * @param player The {@link Player}.
	 */
	public static void remove(final Player player){
		spiderPlayers.remove(player);
	}

	/**
	 * @return the {@link Player}.
	 */
	public Player getPlayer(){
		return player;
	}

	/**
	 * @return a clone of the location.
	 */
	public Location getLocationClone(){
		return location.clone();
	}

	/**
	 * @return a clone of the last location.
	 */
	public Location getLastLocationClone(){
		return lastLocation.clone();
	}

	/**
	 * Get the {@link AlertForce} according to the speed hack score.
	 * @return the {@link AlertForce}.
	 */
	public AlertForce getSpeedHackForce(){
		if(speedhackScore > 2000){
			return AlertForce.CRITICAL;
		}else if(speedhackScore > 1000){
			return AlertForce.FLAGGED;
		}else if(speedhackScore > 500){
			return AlertForce.PROVEN;
		}else if(speedhackScore > 200){
			return AlertForce.SUSPECTED;
		}else if(speedhackScore > 100){
			return AlertForce.POTENTIAL;
		}else{
			return AlertForce.NONE;
		}
	}

	/**
	 * Send a spider alert to the {@link Player}.
	 * @param type Type of your alert.
	 * @param text Extra content of your alert.
	 */
	public void alert(final AlertType type, final Object text){
		alert(type, getSpeedHackForce(), text);
	}

	/**
	 * Send a spider alert to the {@link Player}.
	 * @param type Type of your alert.
	 * @param force Force of your alert.
	 * @param text Extra content of your alert.
	 */
	public void alert(final AlertType type, final AlertForce force, final Object text){
		if(force != AlertForce.NONE) {
			PlayerMessage.sendMessageWithPermission(SpiderPermission.PREVENT_ALERT, "§c[§3Spider§c] " + force.getColor() + force.getName() + " " + type.getName() + " §7§o(" + text.toString() + ")");
		}
	}

	/**
	 * @return If the player has moved between the two positions.
	 */
	public boolean hasMoved(){
		return PlayerMove.hasMoved(location, lastLocation);
	}
}
