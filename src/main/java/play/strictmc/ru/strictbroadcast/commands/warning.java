package play.strictmc.ru.strictbroadcast.commands;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import play.strictmc.ru.strictbroadcast.StrictBroadCast;

public class warning implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        String message = StringUtils.join(args, " ", 0, args.length);
        if (!sender.hasPermission("strict.warning")){
            sender.sendMessage(StrictBroadCast.inst.getConfig().getString("main.warning.NotPermissions").replace("&", "§"));
            return true;
        } else if (args.length <= 0) {
            sender.sendMessage(StrictBroadCast.inst.getConfig().getString("main.warning.argsZiro").replace("&", "§"));
            return true;
        } else if (sender.hasPermission("strict.warning") && (sender instanceof Player)) {
            for (Player allxx : Bukkit.getOnlinePlayers()) {
                allxx.sendMessage(StrictBroadCast.inst.getConfig().getString("main.warning.prefix").replace("&", "§")
                        + " "
                        + message.replace("&", "§")
                        + StrictBroadCast.inst.getConfig().getString("main.warning.suffix").replace("{player}", "" + sender.getName()).replace("&", "§"));
            }
            System.out.println(StrictBroadCast.inst.getConfig().getString("main.warning.prefix").replace("&", "§")
                    + " "
                    + message.replace("&", "§")
                    + StrictBroadCast.inst.getConfig().getString("main.warning.suffix").replace("{player}", "" + sender.getName()).replace("&", "§"));
            return true;
        } else if (!(sender instanceof Player)) {
            for (Player allxx : Bukkit.getOnlinePlayers()) {
                allxx.sendMessage(StrictBroadCast.inst.getConfig().getString("main.warning.prefix").replace("&", "§")
                        + " "
                        + message.replace("&", "§")
                        + StrictBroadCast.inst.getConfig().getString("main.warning.suffix-if-not-player-sender").replace("{player}", "" + StrictBroadCast.inst.getConfig().getString("main.warning.Sender-is-not-player-name")).replace("&", "§"));
            }
            sender.sendMessage(StrictBroadCast.inst.getConfig().getString("main.warning.prefix").replace("&", "§")
                    + " "
                    + message.replace("&", "§")
                    + StrictBroadCast.inst.getConfig().getString("main.warning.suffix-if-not-player-sender").replace("{player}", "" + StrictBroadCast.inst.getConfig().getString("main.warning.Sender-is-not-player-name")).replace("&", "§"));
            return true;

        }
        return false;
    }
}
