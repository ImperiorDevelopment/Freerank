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
            if(args.length == 0){
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
            }else if(args.length >= 1 && args[0].equalsIgnoreCase("reload") && sender.hasPermission(plugin.getConfigFile().getAdminPermission())){
                sender.sendMessage(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', plugin.getMessagesFile().getPrefix()+"&cPlugin has been reloaded"));
            }else if(args.length >= 1 && args[0].equalsIgnoreCase("help") && sender.hasPermission(plugin.getConfigFile().getAdminPermission())){
                sender.sendMessage(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', plugin.getMessagesFile().getPrefix()+"&c&m=============================================="));
                sender.sendMessage(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', plugin.getMessagesFile().getPrefix()+"&c./freerank reload - You can reload the plugin!!"));
                sender.sendMessage(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', plugin.getMessagesFile().getPrefix()+"&c./freerank version - You can reload the plugin!!"));
                sender.sendMessage(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', plugin.getMessagesFile().getPrefix()+"&c&m=============================================="));
            }else if(args.length >= 1 && args[0].equalsIgnoreCase("version")){
                sender.sendMessage(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', plugin.getMessagesFile().getPrefix()+"&c&m=============================================="));
                sender.sendMessage(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', plugin.getMessagesFile().getPrefix()+"&aOfficial Repository: &9https://github.com/ImperiorDevelopment/Freerank/"));
                sender.sendMessage(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', plugin.getMessagesFile().getPrefix()+"&aCreators: &9fran2019 &aAnd &9ale28crack"));
                sender.sendMessage(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', plugin.getMessagesFile().getPrefix()+"&aVersion: &b"+plugin.getDescription().getVersion()));
                sender.sendMessage(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', plugin.getMessagesFile().getPrefix()+"&c&m=============================================="));
            }else{
                sender.sendMessage(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', plugin.getMessagesFile().getPrefix()+plugin.getMessagesFile().getNoPermissionsAdminMessage()));
            }
        }
        return true;
    }
}
//