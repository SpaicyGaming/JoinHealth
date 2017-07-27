package io.github.spaicygaming.joinhealth;

import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.spaicygaming.joinhealth.listener.FoodChangeListener;
import io.github.spaicygaming.joinhealth.listener.JoinEventListerner;
import io.github.spaicygaming.joinhealth.listener.LifeLossListener;

public class JoinHealth extends JavaPlugin implements Listener {
	
	private static JoinHealth instance;

	boolean checkUpdates = getConfig().getBoolean("CheckForUpdates");
	public Object[] updates;
	public String spigotProject = getDescription().getWebsite();
	public String githubProject = "";
	public String ver = getDescription().getVersion();
	
	public void onEnable() {
		instance = this;
		
		saveDefaultConfig();
		
		getServer().getPluginManager().registerEvents(new JoinEventListerner(), this);
		getServer().getPluginManager().registerEvents(new FoodChangeListener(), this);
		getServer().getPluginManager().registerEvents(new LifeLossListener(), this);

		getCommand("joinhealth").setExecutor(new JoinHealthCmdExec());
		
		if (!getConfig().getString("ConfigVersion").equals("1.2")) {
			getLogger().warning(ChatColor.RED + "OUTDATED CONFIG FILE DETECTED, PLEASE DELETE THE OLD ONE!");
		}
		getLogger().info("JoinHealth has been Enabled!");
		
		updates = UpdateChecker.getLastUpdate();
		if (checkUpdates){
			getLogger().info("Checking for updates...");
			
			if (updates.length == 2){
				getLogger().info(getSeparators(70, '='));
				getLogger().info("Update found! Download here: " + spigotProject);
				getLogger().info("Current version: " + ver);
				getLogger().info("New version: " + updates[0]);
				getLogger().info("What's new: " + updates[1]);
				getLogger().info(getSeparators(70, '='));
			} else {
				getLogger().info("No new version available." );
			}
		}
	}

	public void onDisable() {
		getLogger().info("JoinHealth has been Disabled!");
	}
	
	public static JoinHealth getInstance(){
		return instance;
	}
	
	/**
	 * Build a char string
	 * @param value Number of characters
	 * @param charValue The character
	 * @return the string
	 */
	public String getSeparators(int value, char charValue){
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < value; i++){
			sb.append(charValue);
		}
		return sb.toString();
	}	
	

}