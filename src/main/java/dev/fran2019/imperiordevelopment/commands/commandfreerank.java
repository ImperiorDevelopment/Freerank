package dev.fran2019.imperiordevelopment.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class commandfreerank implements CommandExecutor {

    public void enviarComandoConsola(String comando) {
        ConsoleCommandSender consola = Bukkit.getServer().getConsoleSender();
        Bukkit.dispatchCommand(consola, comando);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        

        if(!(sender instanceof Player)){
            Bukkit.getConsoleSender().sendMessage("Comando no Disponible en consola");
        }else{
            if(!sender.hasPermission("freerank.claimed")){
                Player jugador = (Player) sender;
                String nombrejugador = jugador.getName();
                String comando = "lp user "+nombrejugador+" permission set freerank.claimed";
		String comando2 = "lp user "+nombrejugador+" parent addtemp comandante 1d";
                sender.sendMessage(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', "&e&l[Freerank] &aYou Claimed this freerank!"));
                enviarComandoConsola(comando);
		enviarComandoConsola(comando2);
        }else{
                sender.sendMessage(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', "&e&l[Freerank] &cYou have already claimed the freerank!"));
            }
        }
        return true;
    }
}
