package me.tinusium.thekingdom.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import me.tinusium.thekingdom.listeners.Sb;

public class Joinevent implements Listener {
	@EventHandler
	public void PlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		Sb.createScoreboard(p);
	}

}
