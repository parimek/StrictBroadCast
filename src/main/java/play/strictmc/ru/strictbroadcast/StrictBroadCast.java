package play.strictmc.ru.strictbroadcast;

import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import play.strictmc.ru.strictbroadcast.commands.playerbroadcast;
import play.strictmc.ru.strictbroadcast.commands.sbcreload;

public final class StrictBroadCast extends JavaPlugin implements Listener{
    public static StrictBroadCast inst;

    public static StrictBroadCast getInstance(){
        return inst;
    }

    @Override
    public void onEnable() {
        inst = this;
        this.saveDefaultConfig();
        this.getCommand("playerbroadcast").setExecutor(new playerbroadcast());
        this.getCommand("sbcreload").setExecutor(new sbcreload());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
