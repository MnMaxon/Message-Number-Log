package me.MnMaxon.MessageNumberLog;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class MainListener implements Listener {

	@EventHandler(priority = EventPriority.LOWEST)
	public void onChat(AsyncPlayerChatEvent e) {
		YamlConfiguration cfg = Main.setupConfig();
		cfg.set("Messages", cfg.getInt("Messages") + 1);
		Config.Save(cfg, Main.dataFolder + "/Config.yml");
		String message = cfg.getString("Prefix").replace("&0", "" + ChatColor.BLACK)
				.replace("&1", "" + ChatColor.DARK_BLUE).replace("&2", "" + ChatColor.DARK_GREEN)
				.replace("&3", "" + ChatColor.DARK_AQUA).replace("&4", "" + ChatColor.DARK_RED)
				.replace("&5", "" + ChatColor.DARK_PURPLE).replace("&6", "" + ChatColor.GOLD)
				.replace("&7", "" + ChatColor.GRAY).replace("&8", "" + ChatColor.DARK_GRAY)
				.replace("&9", "" + ChatColor.BLUE).replace("&A", "" + ChatColor.GREEN)
				.replace("&B", "" + ChatColor.AQUA).replace("&C", "" + ChatColor.RED)
				.replace("&D", "" + ChatColor.LIGHT_PURPLE).replace("&E", "" + ChatColor.YELLOW)
				.replace("&F", "" + ChatColor.WHITE).replace("&M", "" + ChatColor.STRIKETHROUGH)
				.replace("&N", "" + ChatColor.UNDERLINE).replace("&L", "" + ChatColor.BOLD)
				.replace("&K", "" + ChatColor.MAGIC).replace("&O", "" + ChatColor.ITALIC)
				.replace("&a", "" + ChatColor.GREEN).replace("&b", "" + ChatColor.AQUA)
				.replace("&c", "" + ChatColor.RED).replace("&d", "" + ChatColor.LIGHT_PURPLE)
				.replace("&e", "" + ChatColor.YELLOW).replace("&f", "" + ChatColor.WHITE)
				.replace("&m", "" + ChatColor.STRIKETHROUGH).replace("&n", "" + ChatColor.UNDERLINE)
				.replace("&l", "" + ChatColor.BOLD).replace("&k", "" + ChatColor.MAGIC)
				.replace("&o", "" + ChatColor.ITALIC).replace("&#", "" + cfg.getInt("Messages"));
		if (cfg.getBoolean("Change Format"))
			e.setFormat(message + ChatColor.RESET + e.getFormat());
		else
			e.setMessage(message + ChatColor.RESET + e.getMessage());
	}
}
