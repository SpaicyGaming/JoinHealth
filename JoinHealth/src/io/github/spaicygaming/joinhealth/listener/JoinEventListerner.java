package io.github.spaicygaming.joinhealth.listener;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import io.github.spaicygaming.joinhealth.JoinHealth;
import net.md_5.bungee.api.ChatColor;

public class JoinEventListerner implements Listener {

	private JoinHealth main = JoinHealth.getInstance();
	private FileConfiguration config = main.getConfig();

	@EventHandler(priority = EventPriority.HIGH)
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		/*
		 * FOOD
		 */
		if (config.getBoolean("Join.SetFoodLevel.active")){
			if (p.hasPermission("joinhealth.user"))
				p.setFoodLevel(config.getInt("Join.SetFoodLevel.UsersFoodLevel"));
			
			if (p.hasPermission("joinhealth.vip"))
				p.setFoodLevel(config.getInt("Join.SetFoodLevel.VipsFoodLevel"));
		}
		
		/*
		 * HEALTH
		 */
		if (config.getBoolean("Join.SetHealth.active")){
			if (p.hasPermission("joinhealth.user"))
				p.setFoodLevel(config.getInt("Join.SetFoodLevel.UsersHealthLevel"));
			
			if (p.hasPermission("joinhealth.vip"))
				p.setFoodLevel(config.getInt("Join.SetFoodLevel.VipsHealthLevel"));
		}
		
		/*
		 * JOIN MESSAGE
		 */
		if (config.getBoolean("Join.WelcomeMessage")) {
			p.sendMessage(ChatColor.RED + "   --=-=-=" + ChatColor.GOLD + " JoinHealth " + main.getDescription().getVersion() + ChatColor.RED + " =-=-=--");
			p.sendMessage("");
			p.sendMessage(ChatColor.GOLD + "             Plugin by" + ChatColor.AQUA + ChatColor.ITALIC	+ " SpaicyGaming");
			p.sendMessage(ChatColor.GRAY + " https://www.spigotmc.org/resources/joinhealth.36546/");
			p.sendMessage("");
			p.sendMessage(ChatColor.RED + "---------------------------------------");
		}
		

	}
	
	
	
	

}
