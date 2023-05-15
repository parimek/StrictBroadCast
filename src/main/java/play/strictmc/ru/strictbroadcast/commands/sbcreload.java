package play.strictmc.ru.strictbroadcast.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import play.strictmc.ru.strictbroadcast.StrictBroadCast;

public class sbcreload implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender.hasPermission("strict.sbcreload")){
            StrictBroadCast.inst.reloadConfig();
            sender.sendMessage(StrictBroadCast.inst.getConfig().getString("main.sbcreload.config-reload").replace("&", "§"));
            return true;
        } else {
            sender.sendMessage(StrictBroadCast.inst.getConfig().getString("main.sbcreload.NotPermissions").replace("&", "§"));
        }

        return false;
    }
}
