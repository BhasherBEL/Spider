package be.bhasher.spider.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import be.bhasher.spider.player.SpiderPlayer;
import be.bhasher.spider.utils.player.PlayerPunishment;

public class PreventCommand implements CommandExecutor {

	@Override
	public boolean onCommand(final CommandSender commandSender, final Command command, final String s, final String[] strings) {
		if(strings.length > 0){
			if(strings[0].equalsIgnoreCase("ban")){
				if(strings.length > 1){
					Player preventPlayer = null;
					for(final Player player : Bukkit.getOnlinePlayers()){
						if(player.getName().equals(strings[1])){
							preventPlayer = player;
							break;
						}
					}

					if(preventPlayer != null){
						final StringBuilder reasonBuilder = new StringBuilder();

						for(int i=2;i<strings.length;i++){
							reasonBuilder.append(" " + strings[i]);
						}

						if(reasonBuilder.toString().isEmpty()){
							reasonBuilder.append(" no reason");
						}

						PlayerPunishment.banPlayer(SpiderPlayer.get(preventPlayer), reasonBuilder.toString().substring(1));
						return true;
					}
				}
			}
		}
		return false;
	}
}
