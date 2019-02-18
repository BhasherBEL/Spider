package be.bhasher.spider.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WalkSpeedCommand implements CommandExecutor {

	@Override
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args){
		if (!(sender instanceof Player)) {
			return false;
		}

		if(args.length != 1){
			return false;
		}

		final Player p = (Player) sender;

		final float walkspeed;
		try {
			walkspeed = Float.parseFloat(args[0]);
		} catch (final NumberFormatException ex) {
			return false;
		}
		if(walkspeed > 1 || walkspeed < -1) {
			return false;
		}
		p.setWalkSpeed(walkspeed);
		p.sendMessage("§c[§3Spider§c] §3Walkspeed défini à " + args[0]);

		return true ;
	}

}
