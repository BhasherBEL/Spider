package be.bhasher.spider.player;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_13_R2.v1_13_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import be.bhasher.spider.cheats.SpeedHack;
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
	public final PlayerData pd;

	public Location lastLocation;
	public Location location;
	public Vector move;
	public boolean hasBeenStatic = false ;
	public final SpeedHack speedHack;

	/**
	 * Initializes a new {@link SpiderPlayer}.
	 * @param player The {@link Player} to initialize.
	 */
	private SpiderPlayer(final Player player){
		this.player = player;
		this.lastLocation = player.getLocation();
		this.pd = new PlayerData(player);
		this.speedHack = new SpeedHack(this);
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
	 * @return the {@link Player} ping.
	 */
	public int getPing(){
		return ((CraftPlayer)getPlayer()).getHandle().ping;
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

	public void initStart(){
		pd.update();
		location = getPlayer().getLocation();
		move = location.toVector().subtract(lastLocation.toVector());
	}

	/**
	 * @return If the player has moved between the two positions.
	 */
	public boolean hasMoved(){
		return PlayerMove.hasMoved(location, lastLocation);
	}
}
