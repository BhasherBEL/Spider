package be.bhasher.spider.utils.block;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.util.Vector;

public class BlockUtils {

	public static Vector getComponentDistance(final Block block, final Location location){
		final Location blockLocation = block.getLocation().add( .5, .5, .5);
		final double xDist = Math.max(Math.abs(blockLocation.getX()-location.getX())-.5,0.);
		final double yDist = Math.max(Math.abs(blockLocation.getY()-location.getY())-.5,0.);
		final double zDist = Math.max(Math.abs(blockLocation.getZ()-location.getZ())-.5,0.);

		return new Vector(xDist, yDist, zDist);
	}

	public static double getDistance(final Block block, final Location location){
		return getComponentDistance(block, location).length();
	}

}
