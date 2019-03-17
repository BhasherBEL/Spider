package be.bhasher.spider.utils.player;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.EntityEffect;
import org.bukkit.FireworkEffect;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.inventory.meta.FireworkMeta;

import be.bhasher.spider.permission.SpiderPermission;
import be.bhasher.spider.player.SpiderPlayer;

public class PlayerPunishment {

	public static void banPlayer(final SpiderPlayer sp, final String reason){
		banPlayer(sp, reason, "");
	}

	public static void autoBanPlayer(final SpiderPlayer sp, final String reason){
		autoBanPlayer(sp, reason, "");
	}

	public static void autoBanPlayer(final SpiderPlayer sp, final String reason, final String message){
		if(!sp.getPlayer().hasPermission(SpiderPermission.preventNoAutoBanPermission.getPermission())){
			banPlayer(sp, reason, message);
		}
	}

	public static void banPlayer(final SpiderPlayer sp, final String reason, final String message){
		if(!sp.isSpiderBan){
			sp.isSpiderBan = true;

			final Firework f = (Firework) sp.getPlayer().getLocation().getWorld().spawnEntity(sp.getPlayer().getLocation(), EntityType.FIREWORK);
			f.detonate();
			final FireworkMeta fireworkMeta = f.getFireworkMeta();
			final FireworkEffect fireworkEffect = FireworkEffect.builder()
					.withColor(Color.RED)
					.flicker(true)
					.trail(false)
					.with(FireworkEffect.Type.BALL_LARGE)
					.build();
			fireworkMeta.clearEffects();
			fireworkMeta.addEffect(fireworkEffect);
			f.setFireworkMeta(fireworkMeta);
			sp.getPlayer().playEffect(EntityEffect.FIREWORK_EXPLODE);
			if(!message.equalsIgnoreCase("")){
				Bukkit.broadcastMessage("§c[§3Spider§c] " + message);
			}else{
				Bukkit.broadcastMessage("§c[§3Spider§c] §e"
						+ sp.getPlayer().getName()
						+ " §fhas been banned for §e"
						+ reason
						+ "§f.");
			}

			Bukkit.getBanList(BanList.Type.NAME).addBan(sp.getPlayer().getName(), "§e" + reason, null, null);
			sp.getPlayer().kickPlayer("§eYou §fhave been banned for §e" + reason + "§f.");

		}
	}

}
