package me.tinusium.thekingdom.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.tinusium.thekingdom.Main;
import me.tinusium.thekingdom.listeners.Sb;

public class ScoreboardCMD implements CommandExecutor {
	
	Main main;
	
	public ScoreboardCMD(Main pl) {
		main = pl;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("scoreboard")) {
		if (main.getConfig().getBoolean("scoreboard") == true) {
			Player p = (Player) sender;
			p.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
			main.getConfig().set("scoreboard", false);
			main.saveConfig();
			p.sendMessage(ChatColor.RED + "Je scoreboard staat nu uit!");
		} else if (main.getConfig().getBoolean("scoreboard") == false) {
			Player p = (Player) sender;
			Sb.createScoreboard(p);
			main.getConfig().set("scoreboard", true);
			main.saveConfig();
			p.sendMessage(ChatColor.RED + "Je scoreboard staat nu aan!");
			
		}
		}
		return false;
	}
	
}
