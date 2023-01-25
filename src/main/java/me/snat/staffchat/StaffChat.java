package me.snat.staffchat;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.snat.staffchat.ChatUtils.color;

public class StaffChat implements CommandExecutor {

    private Main main;

    public StaffChat(Main main) {
        this.main = main;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;

        if (!(sender instanceof Player)) return false;

        if (args.length < 1) player.sendMessage("Incorrect Usage!");

        StringBuilder builder = new StringBuilder();
        for (int i = 0 ; i < args.length ; i++) {
            builder.append(args[i]);
        }
        String message = builder.toString();

        for (Player staff : Bukkit.getOnlinePlayers()) {
            if (player.hasPermission("staffchat.use")) {
                staff.sendMessage(color(main.getConfig().getString("message-layout")
                        .replace("{PLAYER}", player.getDisplayName())
                        .replace("{MESSAGE}", message)));
            }
        }

        return false;
    }
}
