package be.bhasher.spider.cheats.move;

import org.bukkit.Material;
import org.bukkit.entity.Animals;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Vehicle;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import be.bhasher.spider.player.SpiderPlayer;

 class MoveDescription {

	 /**
	  * Describes the player's movement and everything that can influence it via {@link Situation} flags.
	  * A player's flags are stored in the {@link SpiderPlayer}.
	  * @param sp The {@link SpiderPlayer}.
	  */
	protected MoveDescription(final SpiderPlayer sp){
		final Material blockType = sp.location.getBlock().getType();
		final PotionEffect jumpPotionEffect = sp.getPlayer().getPotionEffect(PotionEffectType.JUMP);

		// Dead
		if(sp.getPlayer().isDead()){
			sp.situations.add(Situation.DEAD);
		}

		// Jump boost
		if(jumpPotionEffect != null){
			sp.situations.add(Situation.JUMP_BOOST);
		}

		//Boat
		if(!sp.situations.contains(Situation.DEAD)
				&& sp.getPlayer().getVehicle() != null
				&& sp.getPlayer().getVehicle().getType() == EntityType.BOAT){
			sp.situations.add(Situation.BOAT);
		}

		// Minecart
		if(!sp.situations.contains(Situation.DEAD)
				&& sp.getPlayer().getVehicle() != null
				&& sp.getPlayer().getVehicle().getType() == EntityType.MINECART){
			sp.situations.add(Situation.MINECART);
		}

		// Horse
		if(!sp.situations.contains(Situation.DEAD)
				&& sp.getPlayer().getVehicle() != null
				&& sp.getPlayer().getVehicle().getType() == EntityType.HORSE){
			sp.situations.add(Situation.HORSE);
		}

		// On an animals
		if(!sp.situations.contains(Situation.DEAD)
				&& !sp.situations.contains(Situation.HORSE)
				&& sp.getPlayer().getVehicle() != null
				&& sp.getPlayer().getVehicle() instanceof Animals) {
			sp.situations.add(Situation.ON_ANIMALS);
		}

		// On entity
		if(!sp.situations.contains(Situation.DEAD)
				&& !sp.situations.contains(Situation.HORSE)
				&& !sp.situations.contains(Situation.BOAT)
				&& !sp.situations.contains(Situation.MINECART)
				&& !sp.situations.contains(Situation.ON_ANIMALS)
				&& sp.getPlayer().getVehicle() != null
				&& sp.getPlayer().getVehicle() instanceof Vehicle) {
			sp.situations.add(Situation.ON_ENTITY);
		}

		// Fly
		if(!sp.situations.contains(Situation.DEAD)
				&& !sp.situations.contains(Situation.BOAT)
				&& !sp.situations.contains(Situation.MINECART)
				&& !sp.situations.contains(Situation.HORSE)
				&& !sp.situations.contains(Situation.ON_ANIMALS)
				&& sp.getPlayer().isFlying()){
			sp.situations.add(Situation.FLY);
		}

		// Cobweb
		if(!sp.situations.contains(Situation.DEAD)
				&& (blockType == Material.COBWEB || sp.getPlayer().getEyeLocation().getBlock().getType() == Material.COBWEB)){
			sp.situations.add(Situation.COBWEB);
		}

		// On ground
		if(!sp.situations.contains(Situation.DEAD)
				&& !sp.situations.contains(Situation.FLY)
				&& sp.getPlayer().isOnGround()){
			sp.situations.add(Situation.ON_GROUND);
		}

		// Elytra
		if(!sp.situations.contains(Situation.DEAD)
				&& !sp.situations.contains(Situation.FLY)
				&& sp.getPlayer().isGliding() && sp.getPlayer().getInventory().getChestplate().getType() == Material.ELYTRA){
			sp.situations.add(Situation.ELYTRA_FLY);
		}

		// Trident
		if(!sp.situations.contains(Situation.DEAD)
				&& sp.getPlayer().isRiptiding()){
			sp.situations.add(Situation.TRIDENT_FLY);
		}

		// Water
		if(!sp.situations.contains(Situation.DEAD)
				&& (blockType == Material.WATER || sp.getPlayer().getEyeLocation().getBlock().getType() == Material.WATER)){
			if(sp.getPlayer().getEyeLocation().getBlock().getType() == Material.WATER){
				sp.situations.add(Situation.WATER);
			}else{
				sp.situations.add(Situation.MID_WATER);
			}
		}

		// Lava
		if(!sp.situations.contains(Situation.DEAD)
				&& blockType == Material.LAVA || sp.getPlayer().getEyeLocation().getBlock().getType() == Material.LAVA){
			if(sp.getPlayer().getEyeLocation().getBlock().getType() == Material.LAVA){
				sp.situations.add(Situation.LAVA);
			}else{
				sp.situations.add(Situation.MID_LAVA);
			}
		}

		// Swimming
		if(!sp.situations.contains(Situation.DEAD)
				&& !sp.situations.contains(Situation.FLY)
				&& sp.getPlayer().isSwimming()){
			sp.situations.add(Situation.SWIM);
		}

		// Ladder
		if(!sp.situations.contains(Situation.DEAD)
				&& !sp.situations.contains(Situation.FLY)
				&& !sp.situations.contains(Situation.WATER)
				&& !sp.situations.contains(Situation.MID_WATER)
				&& (blockType == Material.LADDER || sp.getPlayer().getEyeLocation().getBlock().getType() == Material.LADDER)){
			if(sp.location.getBlock().getBlockData().getAsString().contains("waterlogged=true")){ // Deprecated
				sp.situations.add((Situation.WATER)); // /!\ MidWater
			}else{
				sp.situations.add(Situation.LADDER);
			}
		}

		// Vine
		if(!sp.situations.contains(Situation.DEAD)
				&& !sp.situations.contains(Situation.FLY)
				&& (blockType == Material.VINE || sp.getPlayer().getEyeLocation().getBlock().getType() == Material.VINE)){
			sp.situations.add(Situation.VINE);
		}

		// Run, Sneak & Walk
		if(!sp.situations.contains(Situation.DEAD)
				&& !sp.situations.contains(Situation.LADDER)
				&& !sp.situations.contains(Situation.VINE)
				&& !sp.situations.contains(Situation.ELYTRA_FLY)
				&& !sp.situations.contains(Situation.SWIM)
				&& !sp.situations.contains(Situation.TRIDENT_FLY)){
			if(sp.getPlayer().isSprinting()){
				sp.situations.add(Situation.RUN);
			}else if(sp.getPlayer().isSneaking()){
				sp.situations.add(Situation.SNEAK);
			}else{
				sp.situations.add(Situation.WALK);
			}
		}

		// Jump
		if(!sp.situations.contains(Situation.DEAD)
				&& !sp.situations.contains(Situation.LADDER)
				&& !sp.situations.contains(Situation.VINE)
				&& !sp.situations.contains(Situation.ELYTRA_FLY)
				&& !sp.situations.contains(Situation.TRIDENT_FLY)
				&& !sp.situations.contains(Situation.WATER)
				&& !sp.situations.contains(Situation.MID_WATER)
				&& !sp.situations.contains(Situation.SWIM)
				&& !sp.situations.contains(Situation.LAVA)
				&& !sp.situations.contains(Situation.MID_LAVA)
				&& !sp.situations.contains(Situation.FLY)
				&& sp.location.getY() > sp.groundY
				&& sp.location.getY() > sp.lastLocation.getY()) {
			sp.situations.add(Situation.JUMP);
		}

		// Free fall -> /!\ Not necessarily a free fall. (ex: minecart, chicken)
		if(!sp.situations.contains(Situation.DEAD)
				&& !sp.situations.contains(Situation.ON_GROUND)
				&& !sp.situations.contains(Situation.LADDER)
				&& !sp.situations.contains(Situation.ELYTRA_FLY)
				&& !sp.situations.contains(Situation.TRIDENT_FLY)
				&& !sp.situations.contains(Situation.WATER)
				&& !sp.situations.contains(Situation.MID_WATER)
				&& !sp.situations.contains(Situation.SWIM)
				&& !sp.situations.contains(Situation.LAVA)
				&& !sp.situations.contains(Situation.MID_LAVA)
				&& !sp.situations.contains(Situation.FLY)
				&& !sp.situations.contains(Situation.VINE)
				&& sp.location.getY() < sp.lastLocation.getY()){
			sp.situations.add(Situation.FREE_FALL);
		}

	}

}
