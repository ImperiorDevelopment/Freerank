package dev.fran2019.imperiordevelopment.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import dev.fran2019.imperiordevelopment.FreeRank;

public class commandfreerank implements CommandExecutor {

    FreeRank plugin = FreeRank.getPlugin(FreeRank.class);

    


    public void enviarComandoConsola(String comando) {
        ConsoleCommandSender consola = Bukkit.getServer().getConsoleSender();
        Bukkit.dispatchCommand(consola, comando);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        

        if(!(sender instanceof Player)){
            Bukkit.getConsoleSender().sendMessage("Comando no Disponible en consola");
        }else{
            if(args.length <= 1 ){
                if(sender.hasPermission(plugin.getConfigFile().getUsePermission())){
                    if(!sender.hasPermission(plugin.getConfigFile().getClaimedPermission())){
                        Player jugador = (Player) sender;
                        String nombrejugador = jugador.getName();
                        String comando = plugin.getConfigFile().getCommandFreeRank().replace("%player%", nombrejugador);
                        String comando2 = plugin.getConfigFile().getCommandFreeRankExecute().replace("%player%", nombrejugador);
                        sender.sendMessage(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', plugin.getMessagesFile().getPrefix()+plugin.getMessagesFile().getClaimMessage()));
                        enviarComandoConsola(comando);
                        enviarComandoConsola(comando2);
                    }else{
                        sender.sendMessage(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', plugin.getMessagesFile().getPrefix()+plugin.getMessagesFile().getAlreadyClaimedMessage()));
                    }
                }else{
                    sender.sendMessage(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', plugin.getMessagesFile().getPrefix()+plugin.getMessagesFile().getNoPermissionsFreeMessage()));
                }
        }else if(args.length == 2 && args[1] == "reload" && sender.hasPermission(plugin.getConfigFile().getAdminPermission())){
            sender.sendMessage(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', plugin.getMessagesFile().getPrefix()+"&cPlugin has been reloaded"));
        }else if(args.length == 2 && args[1] == "help" && sender.hasPermission(plugin.getConfigFile().getAdminPermission())){
            sender.sendMessage(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', plugin.getMessagesFile().getPrefix()+"&c./freerank reload - You can reload the plugin!!"));
            sender.sendMessage(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', plugin.getMessagesFile().getPrefix()+"&c./freerank authors - You can reload the plugin!!"));
        }else if(args.length == 2 && args[1] == "version" || args[1] == "authors"){
            sender.sendMessage(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', plugin.getMessagesFile().getPrefix()+"&cOfficial Repository: https://github.com/ImperiorDevelopment/Freerank/"));
            sender.sendMessage(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', plugin.getMessagesFile().getPrefix()+"&cCreators: &aFran2019 &cAnd &aale28crack"));
            sender.sendMessage(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', plugin.getMessagesFile().getPrefix()+"&cVersion: "+plugin.getDescription().getVersion()));
        }else{
            sender.sendMessage(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', plugin.getMessagesFile().getPrefix()+plugin.getMessagesFile().getNoPermissionsAdminMessage()));
            }
        }
        return true;
    }
}
//