package be.bhasher.spider.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import be.bhasher.spider.SpiderConfig;

/**
 * Class of the walkspeed command (or ws).
 */
public class WalkSpeedCommand implements CommandExecutor {

	/**
	 * Called when the walkspeed (or ws) command is executed. Redefine the player's walkspeed according to the first argument.
	 * @param sender The {@link CommandSender}.
	 * @param cmd The {@link Command}.
	 * @param label The label.
	 * @param args The arguments.
	 * @return if the command has been correctly executed.
	 */
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

		if(SpiderConfig.isUsingWalkSpeed()){
			p.sendMessage("§c§lWARNING§c: §lcheat.speedhack.usingwalkspeed §cis to §ltrue§c. The effects of walkspeed are not taken into account.");
		}

		p.sendMessage("§c[§3Spider§c] §3Walkspeed défini à " + args[0]);

		return true ;
	}

}
