package be.bhasher.spider;

import java.io.File;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class SpiderLang {

	private final FileConfiguration langConfig;

	public SpiderLang(final Plugin plugin, final String langFileName){

		if(!plugin.getDataFolder().exists()){
			plugin.getDataFolder().mkdir();
		}

		final File langFile = new File(plugin.getDataFolder() + File.separator + "lang" + File.separator + langFileName + ".yml");

		if(!langFile.exists() || !langFile.canRead()){
			Bukkit.getLogger().log(Level.SEVERE, "The lang file '{0}' can't be read.", langFileName);
			langConfig = null;
			return;
		}

		langConfig = YamlConfiguration.loadConfiguration(langFile);

	}

	public String get(String link){
		return langConfig.getString(link);
	}

}
