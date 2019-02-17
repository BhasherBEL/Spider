package be.bhasher.spider.utils.player;

import org.bukkit.Location;

public class PlayerMove {

	/**
	 * Check if the first {@link Location} is different from the second.
	 * @param from The first {@link Location}.
	 * @param to The second {@link Location}.
	 * @return if the two positions are different.
	 */
	public static boolean hasMoved(final Location from, final Location to){
		return !from.getWorld().equals(to)
				|| from.getX() != to.getX()
				|| from.getY() != to.getY()
				|| from.getZ() != to.getZ();
	}

}
