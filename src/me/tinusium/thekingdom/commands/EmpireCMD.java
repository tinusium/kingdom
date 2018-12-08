package me.tinusium.thekingdom.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EmpireCMD implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] arg1) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("empirewand")) {
			if (sender.hasPermission("kingdom.empire")){
				ItemStack Empire = new ItemStack(Material.BLAZE_ROD, 1);
	    		ItemMeta EmpireMeta = Empire.getItemMeta();
	    		EmpireMeta.setDisplayName(ChatColor.GOLD + "Empire Wand");
	    		Empire.setItemMeta(EmpireMeta);
	    		
	    		p.getInventory().addItem(Empire);
	    		p.sendMessage("§eJe hebt de Empire Wand gekozen!");
	    		p.closeInventory();
		
			} else {
				p.sendMessage("§4Je hebt hier geen permissies voor");
			}
		}
		return false;
	}

}
