package be.bhasher.spider.utils.player;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import be.bhasher.spider.SpiderConfig;
import be.bhasher.spider.utils.block.BlockNature;
import be.bhasher.spider.utils.block.BlockUtils;
import be.bhasher.spider.utils.data.MoveData;

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
	 * Get the horizontal max speed for a {@link Player}.
	 * @param player The {@link Player}.
	 * @return the horizontal max speed.
	 */
	public static double getHorizontalSpeed(final Player player) {
		return getBaseHorizontalSpeedOnState(player) * getPotionBoost(player) * getBlockBoost(player) * (SpiderConfig.isUsingWalkSpeed() ? player.getWalkSpeed()*5 : 1);
	}

	/**
	 * Get the horizontal speed according to the state.
	 * @param player The {@link Player}.
	 * @return the horizontal speed.
	 */
	private static double getBaseHorizontalSpeedOnState(final Player player) {
		if(player.isSprinting()) {
			if(BlockNature.isSolid(player.getLocation().add(0,2,0).getBlock())){
				if((BlockNature.isTrapDoor(player.getLocation().getBlock())
						|| BlockNature.isTrapDoor(player.getLocation().add(0,1,0).getBlock()))
						&& BlockNature.isIce(player.getLocation().add(0,-1,0).getBlock())) {
					return MoveData.WALK_SPEED * MoveData.ICE_TRAP_UP_BLOCK_BOOST;
				}
				return MoveData.WALK_SPEED * MoveData.UP_BLOCK_BOOST;
			}
			return MoveData.WALK_SPEED * MoveData.SPRINT_BOOST;
		}
		if(player.isSneaking()) {
			return MoveData.WALK_SPEED * MoveData.SNEAK_BOOST;
		}
		return MoveData.WALK_SPEED;
	}

	private static double getBlockBoost(final Player player) {
		if(player.getLocation().add(0,-1,0).getBlock().getType() == Material.SOUL_SAND){
			if(player.getLocation().distance(BlockUtils.getFlatCenter(player.getLocation().getBlock())) < 0.2){
				return MoveData.SOUL_SAND_BOOST;
			}
		}
		return 1;
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
				result += MoveData.POTION_SPEED_BOOST * (effect.getAmplifier()+1);
			} else if (effect.getType().equals(PotionEffectType.SLOW)){
				result -= result * MoveData.POTION_SLOW_BOOST * (effect.getAmplifier()+1);
			}
		}
		return result;
	}

}
