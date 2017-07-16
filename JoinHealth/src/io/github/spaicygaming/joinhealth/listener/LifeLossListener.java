package io.github.spaicygaming.joinhealth.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import io.github.spaicygaming.joinhealth.JoinHealth;

public class LifeLossListener implements Listener{
	
	private JoinHealth main = JoinHealth.getInstance();
	
	@EventHandler
	public void DisableLifeLoss(EntityDamageEvent e) {
		if (main.getConfig().getBoolean("Utils.DisableLifeLoss")) {
			e.setCancelled(true);
		}
	}

}
