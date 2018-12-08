package me.tinusium.thekingdom;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.java.JavaPlugin;

import me.tinusium.thekingdom.commands.EmpireCMD;
import me.tinusium.thekingdom.commands.Kingdomcmd;
import me.tinusium.thekingdom.commands.ScoreboardCMD;
import me.tinusium.thekingdom.events.Joinevent;
import me.tinusium.thekingdom.listeners.Sb;
import me.tinusium.thekingdom.wands.Empire;

public class Main extends JavaPlugin implements Listener {
	
	
	public HashMap<UUID, PermissionAttachment> playerPermissions = new HashMap<>();
	
	public static Main instance;

	public void onEnable() {
		
		getServer().getPluginManager().registerEvents(this, this);
		getServer().getPluginManager().registerEvents(new Sb(), this);
		getServer().getPluginManager().registerEvents(new Joinevent(), this);
		getServer().getPluginManager().registerEvents(new Empire(), this);
		getCommand("scoreboard").setExecutor(new ScoreboardCMD(this));
		getCommand("kingdom").setExecutor(new Kingdomcmd(this));
		getCommand("empirewand").setExecutor(new EmpireCMD());
		getConfig().set("scoreboard", Boolean.TRUE);
		getConfig().options().copyDefaults(true);
		saveConfig();
	}


	
	@EventHandler
	public void breakBlock(BlockBreakEvent event) {
		Player player = event.getPlayer();
		if (!player.hasPermission("kingdom.blockbreak")) {
			event.setCancelled(true);
			player.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.RED + "You do not have  permission to do that!");
		}
	}
	@EventHandler
	public void join(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		setupPermissions(p);
	}
	public void leave(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		playerPermissions.remove(p.getUniqueId());
	}
	
	public void setupPermissions (Player p) {
		PermissionAttachment attachment = p.addAttachment(this);
		this.playerPermissions.put(p.getUniqueId(), attachment);
		permissionsSetter(p.getUniqueId());
		
	}
	private void permissionsSetter(UUID uuid) {
		PermissionAttachment attachment  = this.playerPermissions.get(uuid);
		for(String Kingdoms : this.getConfig().getConfigurationSection("Kingdoms").getKeys(false)) {
			for (String permissions : this.getConfig().getStringList("Kingdoms." + Kingdoms + ".permissions")) {
				attachment.setPermission(permissions, true);
			}
		}
	}
}

