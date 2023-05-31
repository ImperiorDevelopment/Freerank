package dev.fran2019.imperiordevelopment;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import dev.fran2019.imperiordevelopment.commands.imperiordevelopmentCommand;

public class imperiordevelopmentPlugin extends JavaPlugin {
    
    private static imperiordevelopmentPlugin instance;

    @Override
    public void onEnable () {
        Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE+"===================================");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GOLD+"Enabling - "+ChatColor.GREEN+"Freerank");
        Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE+"===================================");
        loadcommands();
        Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE+"===================================");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"Enabled - Freerank");
        Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE+"===================================");
    }

    public void loadcommands() {
        this.getCommand("freerank").setExecutor(new imperiordevelopmentPlugin());
    }
}
