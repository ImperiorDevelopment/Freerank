package dev.fran2019.imperiordevelopment;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import dev.fran2019.imperiordevelopment.commands.commandfreerank;
import pl.mikigal.config.ConfigAPI;
import pl.mikigal.config.annotation.Comment;
import pl.mikigal.config.annotation.ConfigName;
import pl.mikigal.config.style.CommentStyle;
import pl.mikigal.config.style.NameStyle;
public class FreeRank extends JavaPlugin {

    private static ConfigFile configfile;
    private static MessagesFile messagesfile;

    @Override
    public void onEnable () {
        Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE+"===================================");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GOLD+"Enabling - "+ChatColor.GREEN+"Freerank");
        Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE+"===================================");
        loadcommands();
        initconfig();
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED+"Loaded Commands");
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED+"Creators: Fran2019 and Ale28Crack");
        Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE+"===================================");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"Enabled - Freerank");
        Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE+"===================================");
    }

    @ConfigName("config.yml")
    public interface ConfigFile extends pl.mikigal.config.Config {
        //API: https://github.com/mikigal/ConfigAPI
        @Comment("This command is executed when ./freerank is done (Placeholders: %players%)")
        default String commandfreerankexecute() {
            return "lp user %player% parent addtemp comandante 14d";
        }
        @Comment("Please do not touch this if you dont know what are you doing (Placeholders: %players%)")
        default String commandfreerank() {
            return "lp user %player% permission set freerank.claimed";
        }
        @Comment("Admin Permission of the plugin")
        default String adminpermission() {
            return "freerank.admin";
        }
    }
    
    @ConfigName("lang.yml")
    public interface MessagesFile extends pl.mikigal.config.Config {
        //API: https://github.com/mikigal/ConfigAPI
        @Comment("Prefix of the plugin")
        default String prefix() {
            return "&e&l[Freerank]";
        }
        @Comment("This message is a already claimed freerank message.")
        default String alreadyclaimedmessage() {
            return "&cYou have already claimed the freerank!";
        }
        @Comment("This message are a claim freerank message.")
        default String claimmessage() {
            return "aYou Claimed this freerank!";
        }
        @Comment("Error")
        default String errormessage() {
            return "&cError please use &a./freerank";
        }
    }

    public void loadcommands() {
        this.getCommand("freerank").setExecutor(new commandfreerank());
    }

    public void initconfig(){
        configfile = ConfigAPI.init(ConfigFile.class,NameStyle.UNDERSCORE,CommentStyle.INLINE,true,this);
        messagesfile = ConfigAPI.init(MessagesFile.class,NameStyle.UNDERSCORE,CommentStyle.INLINE,true,this);
    }

    public ConfigFile getConfigFile() {
        return configfile;
    }
    public MessagesFile getMessagesFile() {
        return messagesfile;
    }
}
