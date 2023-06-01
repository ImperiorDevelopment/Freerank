package dev.fran2019.imperiordevelopment;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import dev.fran2019.imperiordevelopment.commands.commandfreerank;
public class FreeRank extends JavaPlugin {
    
    @Override
    public void onEnable () {
        Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE+"===================================");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GOLD+"Enabling - "+ChatColor.GREEN+"Freerank");
        Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE+"===================================");
        loadcommands();
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED+"Loaded Commands");
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED+"Creators: Fran2019 and Ale28Crack");
        Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE+"===================================");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"Enabled - Freerank");
        Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE+"===================================");
    }

    public void loadcommands() {
        this.getCommand("freerank").setExecutor(new commandfreerank());
    }
}
