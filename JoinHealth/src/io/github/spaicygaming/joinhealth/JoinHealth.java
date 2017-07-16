package io.github.spaicygaming.joinhealth;

import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.spaicygaming.joinhealth.listener.FoodChangeListener;
import io.github.spaicygaming.joinhealth.listener.JoinEventListerner;
import io.github.spaicygaming.joinhealth.listener.LifeLossListener;

public class JoinHealth extends JavaPlugin implements Listener {
	
	private static JoinHealth instance;

	public void onEnable() {
		instance = this;
		
		saveDefaultConfig();

		getServer().getPluginManager().registerEvents(new FoodChangeListener(), this);
		getServer().getPluginManager().registerEvents(new JoinEventListerner(), this);
		getServer().getPluginManager().registerEvents(new LifeLossListener(), this);

		
		if (!getConfig().getString("ConfigVersion").equals("1.1")) {
			getLogger().warning(ChatColor.RED + "OUTDATED CONFIG FILE DETECTED, PLEASE DELETE THE OLD ONE!");
		}
		getLogger().info("JoinHealth has been Enabled!");

	}

	public void onDisable() {
		getLogger().info("JoinHealth has been Disabled!");
	}
	
	public static JoinHealth getInstance(){
		return instance;
	}

}