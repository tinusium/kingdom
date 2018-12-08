package me.tinusium.thekingdom.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.tinusium.thekingdom.Main;



public class Kingdomcmd implements CommandExecutor {
	
	Main main;
	
	public Kingdomcmd(Main pl) {
		main = pl;
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("kingdom")) {
			if (args.length == 0) {
			p.sendMessage(ChatColor.GOLD + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			p.sendMessage(ChatColor.YELLOW + "/kingdom create");
			p.sendMessage(ChatColor.YELLOW + "/kingdom info");
			p.sendMessage(ChatColor.YELLOW + "/kingdom help");
			p.sendMessage(ChatColor.YELLOW + "/kingdom prefix");
			p.sendMessage(ChatColor.YELLOW + "/kingdom scoreboard");
			p.sendMessage(ChatColor.YELLOW + "/kingdom add");
			p.sendMessage(ChatColor.GOLD + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			
		} 
			
			if(args.length >= 2) {

                if(args[0].equalsIgnoreCase("create")) {

                    String name = args[1];

                    main.getConfig().set("Kingdoms." + name, "");
                    main.saveConfig();
                    sender.sendMessage("§6[§eKingdom§6] §aJe hebt succesvoll de kingdom §c" + String.valueOf(name) + "§a aangemaakt");
			}
		}
	}
	
	return false;
	}
}
