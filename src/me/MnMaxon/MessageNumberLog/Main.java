package me.MnMaxon.MessageNumberLog;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
	public static String dataFolder;
	public static Main plugin;

	@Override
	public void onEnable() {
		plugin = this;
		dataFolder = this.getDataFolder().getAbsolutePath();
		setupConfig();
		getServer().getPluginManager().registerEvents(new MainListener(), this);
	}

	public static YamlConfiguration setupConfig() {
		cfgSetter("Prefix", "&5[&4&#&5] &f");
		cfgSetter("Messages", 0);
		cfgSetter("Change Format", true);
		return Config.Load(dataFolder + "/Config.yml");
	}

	public static void cfgSetter(String path, Object value) {
		YamlConfiguration cfg = Config.Load(dataFolder + "/Config.yml");
		if (cfg.get(path) == null) {
			cfg.set(path, value);
			Config.Save(cfg, dataFolder + "/Config.yml");
		}
	}
}