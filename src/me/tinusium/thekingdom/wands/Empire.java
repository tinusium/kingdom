package me.tinusium.thekingdom.wands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Empire implements Listener{

	
	
    @SuppressWarnings("deprecation")
	@EventHandler
    public void onInteraction(PlayerInteractEvent e){
    	ItemStack Empire = new ItemStack(Material.BLAZE_ROD, 1);
    	ItemMeta EmpireMeta = Empire.getItemMeta();
    	EmpireMeta.setDisplayName(ChatColor.GOLD + "Empire Wand");
    	Empire.setItemMeta(EmpireMeta);
    	
          Player p = e.getPlayer();
        	 if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() ==Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK|| e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (p.getItemInHand().getType() == Material.BLAZE_ROD){
            	if(p.getItemInHand().equals(Empire)) {
 
              p.getLocation().getDirection().normalize().multiply(1);
              p.launchProjectile(Fireball.class);
            	}
            }
        }   
    }
}
