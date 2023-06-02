package dev.fran2019.imperiordevelopment;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import dev.fran2019.imperiordevelopment.commands.commandfreerank;
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
    public interface ConfigFile extends Config {
        //API: https://github.com/mikigal/ConfigAPI
        @Comment("This command is executed when ./freerank is done")
        default String commandfreerankexecute() {
            return "";
        }
        @Comment("Please do not touch this if you dont know what are you doing")
        default String commandfreerank() {
            return "";
        }
    }
    @ConfigName("messages.yml")
    public interface MessagesFile extends Config {
        //API: https://github.com/mikigal/ConfigAPI
        @Comment("This message is a already claimed freerank message.")
        default String alreadyclaimedmessage() {
            return "";
        }
        @Comment("This message are a claim freerank message.")
        default String claimmessage() {
            return "";
        }
    }

    public void loadcommands() {
        this.getCommand("freerank").setExecutor(new commandfreerank());
    }

    public void initconfig(){
        configfile = ConfigAPI.init(ConfigFile.class,NameStyle.UNDERSCORE,CommentStyle.INLINE,true,this);
        messagesfile = ConfigAPI.init(MessagesFile.class,NameStyle.UNDERSCORE,CommentStyle.INLINE,true,this);

    }

}
