package play.strictmc.ru.strictbroadcast.commands;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import play.strictmc.ru.strictbroadcast.StrictBroadCast;

public class playerbroadcast implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        String message = StringUtils.join(args, " ", 0, args.length);
        if (!sender.hasPermission("strict.playerbroadcast")){
            sender.sendMessage(StrictBroadCast.inst.getConfig().getString("main.playerbroadcast.NotPermissions").replace("&", "§"));
            return true;
        } else if (args.length <= 0) {
            sender.sendMessage(StrictBroadCast.inst.getConfig().getString("main.playerbroadcast.argsZiro").replace("&", "§"));
            return true;
        } else if (sender.hasPermission("strict.playerbroadcast") && (sender instanceof Player)) {
            for (Player allxx : Bukkit.getOnlinePlayers()) {
                allxx.sendMessage(StrictBroadCast.inst.getConfig().getString("main.playerbroadcast.prefix").replace("&", "§")
                        + " "
                        + message.replace("&", "§")
                        + StrictBroadCast.inst.getConfig().getString("main.playerbroadcast.suffix").replace("{player}", "" + sender.getName()).replace("&", "§"));
            }
            System.out.println(StrictBroadCast.inst.getConfig().getString("main.playerbroadcast.prefix").replace("&", "§")
                    + " "
                    + message.replace("&", "§")
                    + StrictBroadCast.inst.getConfig().getString("main.playerbroadcast.suffix").replace("{player}", "" + sender.getName()).replace("&", "§"));
            return true;
        } else if (!(sender instanceof Player)) {
            for (Player allxx : Bukkit.getOnlinePlayers()) {
                allxx.sendMessage(StrictBroadCast.inst.getConfig().getString("main.playerbroadcast.prefix").replace("&", "§")
                        + " "
                        + message.replace("&", "§")
                        + StrictBroadCast.inst.getConfig().getString("main.playerbroadcast.suffix").replace("{player}", "" + StrictBroadCast.inst.getConfig().getString("main.playerbroadcast.Sender-is-not-player-name")).replace("&", "§"));
            }
            sender.sendMessage(StrictBroadCast.inst.getConfig().getString("main.playerbroadcast.prefix").replace("&", "§")
                    + " "
                    + message.replace("&", "§")
                    + StrictBroadCast.inst.getConfig().getString("main.playerbroadcast.suffix").replace("{player}", "" + StrictBroadCast.inst.getConfig().getString("main.playerbroadcast.Sender-is-not-player-name")).replace("&", "§"));
            return true;

        }
        return false;
    }
}
