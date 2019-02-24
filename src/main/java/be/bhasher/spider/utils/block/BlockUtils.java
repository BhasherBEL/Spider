package be.bhasher.spider.utils.block;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Bed;
import org.bukkit.block.data.type.Chest;
import org.bukkit.block.data.type.Door;
import org.bukkit.block.data.type.EnderChest;
import org.bukkit.block.data.type.Fence;
import org.bukkit.block.data.type.Piston;
import org.bukkit.block.data.type.PistonHead;
import org.bukkit.block.data.type.Slab;
import org.bukkit.block.data.type.Stairs;
import org.bukkit.block.data.type.TrapDoor;
import org.bukkit.material.Step;
import org.bukkit.material.WoodenStep;

public class BlockUtils {

	public static boolean isSolid(final Block block) {
		return isSolid(block.getType());
	}

	public static boolean isSolid(final Material material) {
		return material.isSolid();
	}

	public static boolean isLiquid(final Block block) {
		return isLiquid(block.getType());
	}

	public static boolean isLiquid(final Material material) {
		return (material == Material.WATER || material == Material.LAVA);
	}

	public static boolean isIce(final Block block) {
		return isIce(block.getType());
	}

	public static boolean isIce(final Material material) {
		return (material == Material.ICE || material == Material.BLUE_ICE || material == Material.PACKED_ICE || material == Material.FROSTED_ICE);
	}

	public static boolean isCobweb(final Block block) {
		return isCobweb(block.getType());
	}

	public static boolean isCobweb(final Material material) {
		return material == Material.COBWEB;
	}

	public static boolean isClimbable(final Block block) {
		return isClimbable(block.getType());
	}

	public static boolean isClimbable(final Material material) {
		return (material == Material.LADDER || material == Material.VINE);
	}

	public static boolean isFence(final Block block) {
		return isFence(block.getType());
	}

	public static boolean isFence(final Material material){
		return material.data == Fence.class;
	}

	public static boolean isDoor(final Block block) {
		return isDoor(block.getType());
	}

	public static boolean isDoor(final Material material) {
		return material.data == Door.class;
	}

	public static boolean isBed(final Block block) {
		return isBed(block.getType());
	}

	public static boolean isBed(final Material material) {
		return material.data == Bed.class;
	}

	public static boolean isTrapDoor(final Block block) {
		return isTrapDoor(block.getType());
	}

	public static boolean isTrapDoor(final Material material) {
		return material.data == TrapDoor.class;
	}

	public static boolean isChest(final Block block) {
		return isChest(block.getType());
	}

	@Deprecated
	public static boolean isChest(final Material material) {
		return material.data == Chest.class || material.data == EnderChest.class || material.toString().contains("SHULKER_BOX") ;
	}

	public static boolean isPiston(final Block block) {
		return isPiston(block.getType());
	}

	public static boolean isPiston(final Material material) {
		return material.data == Piston.class || material.data == PistonHead.class;
	}

	public static boolean isFenceGate(final Block block) {
		return isFenceGate(block.getType());
	}

	public static boolean isFenceGate(final Material material) {
		return material.data == Fence.class;
	}

	public static boolean isStair(final Block block) {
		return isStair(block.getType());
	}

	public static boolean isStair(final Material material) {
		return material.data == Stairs.class;
	}

	public static boolean isSlab(final Block block) {
		return isSlab(block.getType());
	}

	public static boolean isSlab(final Material material) {
		return material.data == Slab.class || material.data == WoodenStep.class || material.data == Step.class;
	}

}
