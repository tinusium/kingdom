package me.tinusium.thekingdom.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import me.tinusium.thekingdom.Main;


public class Sb implements Listener {
	
	  static Team team;
	  static Scoreboard board;    
	  
	  public static void createScoreboard(Player p) {
		  board = Bukkit.getScoreboardManager().getNewScoreboard();
		  Objective obj = board.registerNewObjective("test", "dummy");
		  obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		
		  long health = Math.round(p.getHealth());
		  
		  team = board.registerNewTeam("team");
        team.setPrefix("");
        String title = ChatColor.RED + "The Kingdom";
        String line14 = "";
        String line13 = "";
        String line12 = "";
        String line11 = "";
        String line10 = "";
        String line9 = "";
        String line8 = "§3Kingdom:";
        String line7 = "§bSpelers KD";
        String line6 = "§c  ";
        String line5 = "§3Rang:";
        String line4 = "§bSpelers rang";
        String line3 = "§f  ";
        String line2 = "§3Health";
        String line1 = ChatColor.AQUA + String.valueOf(health);
            obj.setDisplayName(title);
            obj.getScore(line14).setScore(14);
            obj.getScore(line13).setScore(13);
            obj.getScore(line12).setScore(12);
            obj.getScore(line11).setScore(11);
            obj.getScore(line10).setScore(10);
            obj.getScore(line9).setScore(9);
            obj.getScore(line8).setScore(8);
            obj.getScore(line7).setScore(7);
            obj.getScore(line6).setScore(6);
            obj.getScore(line5).setScore(5);
            obj.getScore(line4).setScore(4);
            obj.getScore(line3).setScore(3);
            obj.getScore(line2).setScore(2);
            obj.getScore(line1).setScore(1);
//        refresh(p);
        p.setScoreboard(board);
        scoreboard = true;
        
	  }
	  
	  
	  
	    public static void refresh(final Player p){
	    	  
	        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.instance, new Runnable() {
	             public void run() {
	            	 createScoreboard(p);
	            	 p.setScoreboard(board);
	             }
	         }, 20L, 20L);
	                  
	      

	    }
	    
	    
	    private static boolean scoreboard;
	    
	    public static boolean isScoreboardEnabled(Player p) {
	    	return scoreboard;
	    }
	    
	    public static void setScoreboardDisabled(Player p) {
	    	scoreboard = false;
	    }

}