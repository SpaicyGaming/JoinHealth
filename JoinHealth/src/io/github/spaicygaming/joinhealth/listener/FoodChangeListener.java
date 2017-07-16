package io.github.spaicygaming.joinhealth.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import io.github.spaicygaming.joinhealth.JoinHealth;

public class FoodChangeListener implements Listener{

	private JoinHealth main = JoinHealth.getInstance();
	
	@EventHandler
	public void onFoodChange(FoodLevelChangeEvent e) {
		if (main.getConfig().getBoolean("Utils.DisableHungerLoss")) {
			e.setCancelled(true);
		}
	}
	
}
