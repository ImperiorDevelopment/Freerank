package dev.fran2019.imperiordevelopment;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import dev.fran2019.imperiordevelopment.commands.commandfreerank;
import pl.mikigal.config.Config;
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
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED+"Loaded Commands");
        initconfig();
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED+"Loaded Config");
        Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE+"===================================");
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED+"Version: "+getDescription().getVersion());
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED+"Creators: "+getDescription().getAuthors());
        Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE+"===================================");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"Enabled - Freerank");
        Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE+"===================================");
    }

    @ConfigName("config.yml")
    public interface ConfigFile extends Config {
        //API: https://github.com/mikigal/ConfigAPI
        @Comment("This command is executed when ./freerank is done (Placeholders: %players%)")
        default String getCommandFreeRankExecute() {
            return "lp user %player% parent addtemp comandante 14d";
        }
        @Comment("Please do not touch this if you dont know what are you doing (Placeholders: %players%)")
        default String getCommandFreeRank() {
            return "lp user %player% permission set freerank.claimed";
        }
        @Comment("Admin Permission of the plugin")
        default String getAdminPermission() {
            return "freerank.admin";
        }
        @Comment("Admin Permission of the plugin")
        default String getUsePermission() {
            return "freerank.use";
        }
        @Comment("Admin Permission of the plugin")
        default String getClaimedPermission() {
            return "freerank.claimed";
        }
    }
    
    @ConfigName("lang.yml")
    public interface MessagesFile extends Config {
        //API: https://github.com/mikigal/ConfigAPI
        @Comment("Prefix of the plugin")
        default String getPrefix() {
            return "&e&l[Freerank] ";
        }
        @Comment("This message is a already claimed freerank message.")
        default String getAlreadyClaimedMessage() {
            return "&cYou have already claimed the freerank!";
        }
        @Comment("This message are a claim freerank message.")
        default String getClaimMessage() {
            return "&aYou Claimed this freerank!";
        }
        @Comment("Error")
        default String getErrorMessage() {
            return "&cError please use &a/freerank help";
        }
        @Comment("This message are a no permissions freerank message.")
        default String getNoPermissionsFreeMessage() {
            return "&cError you do not have permissions";
        }
        @Comment("This message are a no permissions freerank message.")
        default String getNoPermissionsAdminMessage() {
            return "&cError you do not have permissions";
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