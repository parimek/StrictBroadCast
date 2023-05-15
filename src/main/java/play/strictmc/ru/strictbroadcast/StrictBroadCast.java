package play.strictmc.ru.strictbroadcast;

import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import play.strictmc.ru.strictbroadcast.commands.playerbroadcast;
import play.strictmc.ru.strictbroadcast.commands.sbcreload;
import play.strictmc.ru.strictbroadcast.commands.warning;

public final class StrictBroadCast extends JavaPlugin implements Listener{
    public static StrictBroadCast inst;

    public static StrictBroadCast getInstance(){
        return inst;
    }

    @Override
    public void onEnable() {
        inst = this;
        this.saveDefaultConfig();
        //Объявления от игроков
        if (StrictBroadCast.inst.getConfig().getBoolean("main.playerbroadcast.enable")){
            this.getCommand("playerbroadcast").setExecutor(new playerbroadcast());
        } else {
            System.out.println(StrictBroadCast.inst.getConfig().getString("main.playerbroadcast.disable"));
        }
        //Предупреждения
        if (StrictBroadCast.inst.getConfig().getBoolean("main.warning.enable")) {
            this.getCommand("warning").setExecutor(new warning());
        } else {
            System.out.println(StrictBroadCast.inst.getConfig().getString("main.warning.disable"));
        }
        //Перезагрузка конфига
        this.getCommand("sbcreload").setExecutor(new sbcreload());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
