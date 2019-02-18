package be.bhasher.spider;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import be.bhasher.spider.commands.WalkSpeedCommand;
import be.bhasher.spider.listener.SpiderPlayerListener;
import be.bhasher.spider.player.SpiderPlayer;

public class Spider extends JavaPlugin {

	private static Plugin 		instance;

	/**
	 * Execute the launch.
	 */
	@Override
	public void onEnable() {
		saveDefaultConfig();
		instance = this;
		SpiderPlayer.resetPlayers() ;
		getCommand("walkspeed").setExecutor(new WalkSpeedCommand());
		getServer().getPluginManager().registerEvents(new SpiderPlayerListener(), this);
	}

	/**
	 * Get the instance of the plugin.
	 * @return the instance.
	 */
	public static Plugin getInstance() {
		return instance;
	}

}
