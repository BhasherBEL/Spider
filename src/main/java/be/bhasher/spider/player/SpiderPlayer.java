package be.bhasher.spider.player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import be.bhasher.spider.alerts.AlertType;
import be.bhasher.spider.cheats.move.MoveRunnable;
import be.bhasher.spider.cheats.move.Situation;

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
	public Vector lastSpeed;
	public Vector speed;
	public double groundY;
	public double groundTime;
	public Vector airSpeed;
	public ArrayList<Situation> situations = new ArrayList<>();

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
			SpiderPlayer.set(player);
		}
	}

	/**
	 * Define a {@link SpiderPlayer}.
	 * @param player The {@link Player} to define.
	 */
	public static void set(final Player player){
		if(!spiderPlayers.containsKey(player)) {
			spiderPlayers.put(player, new SpiderPlayer(player));
			new MoveRunnable(player);
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
	 * Send a spider alert to the {@link Player}.
	 * @param alertType Type of your alert.
	 * @param text Extra content of your alert.
	 */
	public void alert(final AlertType alertType, final String text){

		player.sendMessage("§c[§3Spider§c]§f " + alertType.getName() + " §7§o(" + text + ")");
	}
}
