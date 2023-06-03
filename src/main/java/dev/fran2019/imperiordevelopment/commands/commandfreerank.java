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
            if(args.length <= 0 ){
                if(!sender.hasPermission("freerank.claimed")){
                    Player jugador = (Player) sender;
                    String nombrejugador = jugador.getName();
                    String comando = plugin.getConfigFile().commandfreerank().replace("%player%", nombrejugador);
                    String comando2 = plugin.getConfigFile().commandfreerankexecute().replace("%player%", nombrejugador);
                    sender.sendMessage(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', plugin.getMessagesFile().prefix()+plugin.getMessagesFile().claimmessage()));
                    enviarComandoConsola(comando);
                    enviarComandoConsola(comando2);
                }else{
                    sender.sendMessage(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', plugin.getMessagesFile().prefix()+plugin.getMessagesFile().alreadyclaimedmessage()));
                }
        }else if(args.length == 1 && args[1] == "reload" && sender.hasPermission(plugin.getConfigFile().adminpermission())){
            sender.sendMessage(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', plugin.getMessagesFile().prefix()+"&cPlugin has been reloaded"));
        }else if(args.length == 1 && args[1] == "help" && sender.hasPermission(plugin.getConfigFile().adminpermission())){
            sender.sendMessage(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', plugin.getMessagesFile().prefix()+"&c./freerank reload - You can reload the plugin!!"));
        }else if(args.length == 1 && args[1] == "version" || args[1] == "authors"){
            sender.sendMessage(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', plugin.getMessagesFile().prefix()+"&cOfficial Repository: https://github.com/ImperiorDevelopment/Freerank/"));
        }else{
            sender.sendMessage(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', plugin.getMessagesFile().prefix()+"&cError please use &a./freerank"));
            }
        }
        return true;
    }
}
