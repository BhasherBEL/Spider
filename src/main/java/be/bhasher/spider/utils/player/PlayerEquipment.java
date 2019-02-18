package be.bhasher.spider.utils.player;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

/**
 * Class managing a player's equipment.
 */
public class PlayerEquipment {

	/**
	 * Check if the {@link Player} has equipped elytra.
	 * @param player The {@link Player} to check on.
	 * @return if the {@link Player} has elytra.
	 */
	public static boolean hasElytra(final Player player){
		return player != null && player.getInventory().getChestplate() != null && player.getInventory().getChestplate().getType() == Material.ELYTRA;
	}

	/**
	 * Check if the {@link Player} is gliding with elytra.
	 * @param player The {@link Player} to check on.
	 * @return if the {@link Player} glide with elytra.
	 */
	public static boolean isGlidingWithElytra(final Player player){
		return hasElytra(player) && player.isGliding();
	}

	/**
	 * Checks if the {@link Player} is levitating with a levitation {@link PotionEffectType}.
	 * @param player The {@link Player} to check on.
	 * @return if the {@link Player} is levitating.
	 */
	public static boolean isLevitating(final Player player){
		return player != null && player.getPotionEffect(PotionEffectType.LEVITATION) != null ;
	}

}
