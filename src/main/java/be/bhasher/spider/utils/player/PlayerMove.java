package be.bhasher.spider.utils.player;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import be.bhasher.spider.SpiderConfig;

/**
 * Class managing the player's movements.
 */
public class PlayerMove {

	/**
	 * Check if the first {@link Location} is different from the second.
	 * @param from The first {@link Location}.
	 * @param to The second {@link Location}.
	 * @return if the two positions are different.
	 */
	public static boolean hasMoved(final Location from, final Location to){
		return !from.getWorld().equals(to.getWorld())
				|| from.getX() != to.getX()
				|| from.getY() != to.getY()
				|| from.getZ() != to.getZ();
	}

	/**
	 * Walk speed constant.
	 */
	private static final double WALK_SPEED = 4.317;

	/**
	 * Get the horizontal max speed for a {@link Player}.
	 * @param player The {@link Player}.
	 * @return the horizontal max speed.
	 */
	public static double getHorizontalSpeed(final Player player) {
		return getBaseHorizontalSpeedOnState(player) * getPotionBoost(player) * (SpiderConfig.isUsingWalkSpeed() ? player.getWalkSpeed()*5 : 1);
	}

	/**
	 * Get the horizontal speed according to the state.
	 * @param player The {@link Player}.
	 * @return the horizontal speed.
	 */
	private static double getBaseHorizontalSpeedOnState(final Player player) {
		if(player.isSprinting()) {
			return WALK_SPEED*1.3;
		}
		if(player.isSneaking()) {
			return WALK_SPEED*0.3;
		}
		return WALK_SPEED;
	}

	/**
	 * Speed multiplier according to potions.
	 * @param player The {@link Player}.
	 * @return the speed multiplier.
	 */
	private static double getPotionBoost(final Player player) {
		double result = 1.;
		for (final PotionEffect effect : player.getActivePotionEffects()) {
			if (effect.getType().equals(PotionEffectType.SPEED)) {
				result += 0.2 * (effect.getAmplifier()+1);
			} else if (effect.getType().equals(PotionEffectType.SLOW)){
				result -= result*0.15 * (effect.getAmplifier()+1);
			}
		}
		return result;
	}

}
