package be.bhasher.spider;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import be.bhasher.spider.cheats.CheatListener;
import be.bhasher.spider.commands.PreventCommand;
import be.bhasher.spider.commands.WalkSpeedCommand;
import be.bhasher.spider.listener.SpiderPlayerListener;
import be.bhasher.spider.player.SpiderPlayer;

/**
 * Main class of the plugin.
 */
public class Spider extends JavaPlugin {

	private static Plugin 		instance;

	/**
	 * Execute the plugin.
	 */
	@Override
	public void onEnable() {
		saveDefaultConfig();
		instance = this;
		SpiderPlayer.resetPlayers() ;
		getCommand("walkspeed").setExecutor(new WalkSpeedCommand());
		getCommand("prevent").setExecutor(new PreventCommand());
		getServer().getPluginManager().registerEvents(new SpiderPlayerListener(), this);
		getServer().getPluginManager().registerEvents(new CheatListener(), this);
	}

	/**
	 * Get the instance of the plugin.
	 * @return the instance.
	 */
	public static Plugin getInstance() {
		return instance;
	}

}
