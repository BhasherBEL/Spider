package be.bhasher.spider.utils.block;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Bed;
import org.bukkit.block.data.type.Chest;
import org.bukkit.block.data.type.Door;
import org.bukkit.block.data.type.EnderChest;
import org.bukkit.block.data.type.Fence;
import org.bukkit.block.data.type.Gate;
import org.bukkit.block.data.type.Piston;
import org.bukkit.block.data.type.PistonHead;
import org.bukkit.block.data.type.Slab;
import org.bukkit.block.data.type.Stairs;
import org.bukkit.block.data.type.TrapDoor;
import org.bukkit.material.Step;
import org.bukkit.material.WoodenStep;

/**
 * Information about the nature of a block.
 */
public class BlockNature {

	/**
	 * Is the block solid ?
	 * @param block the {@link Block}.
	 * @return true if the block is solid, false otherwise.
	 */
	public static boolean isSolid(final Block block) {
		return isSolid(block.getType());
	}

	/**
	 * Is the material solid ?
	 * @param material the {@link Material}.
	 * @return true if the material is solid, false otherwise.
	 */
	public static boolean isSolid(final Material material) {
		return material.isSolid();
	}

	/**
	 * Is the block liquid ?
	 * @param block the {@link Block}.
	 * @return true if the block is liquid, false otherwise.
	 */
	public static boolean isLiquid(final Block block) {
		return isLiquid(block.getType());
	}

	/**
	 * Is the material liquid ?
	 * @param material the {@link Material}.
	 * @return true if the material is liquid, false otherwise.
	 */
	public static boolean isLiquid(final Material material) {
		return (material == Material.WATER || material == Material.LAVA);
	}

	/**
	 * Is the block ice ?
	 * @param block the {@link Block}.
	 * @return true if the block is ice, false otherwise.
	 */
	public static boolean isIce(final Block block) {
		return isIce(block.getType());
	}

	/**
	 * Is the material ice ?
	 * @param material the {@link Material}.
	 * @return true if the material is ice, false otherwise.
	 */
	public static boolean isIce(final Material material) {
		return (material == Material.ICE || material == Material.BLUE_ICE || material == Material.PACKED_ICE || material == Material.FROSTED_ICE);
	}

	/**
	 * Is the block cobweb ?
	 * @param block the {@link Block}.
	 * @return true if the block is cobweb, false otherwise.
	 */
	public static boolean isCobweb(final Block block) {
		return isCobweb(block.getType());
	}

	/**
	 * Is the material cobweb ?
	 * @param material the {@link Material}.
	 * @return true if the material is cobweb, false otherwise.
	 */
	public static boolean isCobweb(final Material material) {
		return material == Material.COBWEB;
	}

	/**
	 * Is the block climbable ?
	 * @param block the {@link Block}.
	 * @return true if the block is climbable, false otherwise.
	 */
	public static boolean isClimbable(final Block block) {
		return isClimbable(block.getType());
	}

	/**
	 * Is the material climbable ?
	 * @param material the {@link Material}.
	 * @return true if the material is climbable, false otherwise.
	 */
	public static boolean isClimbable(final Material material) {
		return (material == Material.LADDER || material == Material.VINE);
	}

	/**
	 * Is the block fence ?
	 * @param block the {@link Block}.
	 * @return true if the block is fence, false otherwise.
	 */
	public static boolean isFence(final Block block) {
		return isFence(block.getType());
	}

	/**
	 * Is the material fence ?
	 * @param material the {@link Material}.
	 * @return true if the material is fence, false otherwise.
	 */
	public static boolean isFence(final Material material){
		return material.data == Fence.class;
	}

	/**
	 * Is the block door ?
	 * @param block the {@link Block}.
	 * @return true if the block is door, false otherwise.
	 */
	public static boolean isDoor(final Block block) {
		return isDoor(block.getType());
	}

	/**
	 * Is the material door ?
	 * @param material the {@link Material}.
	 * @return true if the material is door, false otherwise.
	 */
	public static boolean isDoor(final Material material) {
		return material.data == Door.class;
	}

	/**
	 * Is the block bed ?
	 * @param block the {@link Block}.
	 * @return true if the block is bed, false otherwise.
	 */
	public static boolean isBed(final Block block) {
		return isBed(block.getType());
	}

	/**
	 * Is the material bed ?
	 * @param material the {@link Material}.
	 * @return true if the material is bed, false otherwise.
	 */
	public static boolean isBed(final Material material) {
		return material.data == Bed.class;
	}

	/**
	 * Is the block trapdoor ?
	 * @param block the {@link Block}.
	 * @return true if the block is trapdoor, false otherwise.
	 */
	public static boolean isTrapDoor(final Block block) {
		return isTrapDoor(block.getType());
	}

	/**
	 * Is the material trapdoor ?
	 * @param material the {@link Material}.
	 * @return true if the material is trapdoor, false otherwise.
	 */
	public static boolean isTrapDoor(final Material material) {
		return material.data == TrapDoor.class;
	}

	/**
	 * Is the block chest ?
	 * @param block the {@link Block}.
	 * @return true if the block is chest, false otherwise.
	 */
	public static boolean isChest(final Block block) {
		return isChest(block.getType());
	}

	/**
	 * Is the material chest ?
	 * @param material the {@link Material}.
	 * @return true if the material is chest, false otherwise.
	 */
	@Deprecated
	public static boolean isChest(final Material material) {
		return material.data == Chest.class || material.data == EnderChest.class || material.toString().contains("SHULKER_BOX") ;
	}

	/**
	 * Is the block piston ?
	 * @param block the {@link Block}.
	 * @return true if the block is piston, false otherwise.
	 */
	public static boolean isPiston(final Block block) {
		return isPiston(block.getType());
	}

	/**
	 * Is the material piston ?
	 * @param material the {@link Material}.
	 * @return true if the material is piston, false otherwise.
	 */
	public static boolean isPiston(final Material material) {
		return material.data == Piston.class || material.data == PistonHead.class;
	}

	/**
	 * Is the block fence gate ?
	 * @param block the {@link Block}.
	 * @return true if the block is fence gate, false otherwise.
	 */
	public static boolean isFenceGate(final Block block) {
		return isFenceGate(block.getType());
	}

	/**
	 * Is the material fence gate ?
	 * @param material the {@link Material}.
	 * @return true if the material is fence gate, false otherwise.
	 */
	public static boolean isFenceGate(final Material material) {
		return material.data == Gate.class;
	}

	/**
	 * Is the block stair ?
	 * @param block the {@link Block}.
	 * @return true if the block is stair, false otherwise.
	 */
	public static boolean isStair(final Block block) {
		return isStair(block.getType());
	}

	/**
	 * Is the material stair ?
	 * @param material the {@link Material}.
	 * @return true if the material is stair, false otherwise.
	 */
	public static boolean isStair(final Material material) {
		return material.data == Stairs.class;
	}

	/**
	 * Is the block slab ?
	 * @param block the {@link Block}.
	 * @return true if the block is slab, false otherwise.
	 */
	public static boolean isSlab(final Block block) {
		return isSlab(block.getType());
	}

	/**
	 * Is the material slab ?
	 * @param material the {@link Material}.
	 * @return true if the material is slab, false otherwise.
	 */
	public static boolean isSlab(final Material material) {
		return material.data == Slab.class || material.data == WoodenStep.class || material.data == Step.class;
	}

}
