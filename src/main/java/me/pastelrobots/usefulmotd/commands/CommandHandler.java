package me.pastelrobots.usefulmotd.commands;

import me.pastelrobots.usefulmotd.UsefulMOTD;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class CommandHandler implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender s, @NotNull Command c, @NotNull String l, @NotNull String[] args) {
        if(c.getName().equalsIgnoreCase("usefulmotd")) {
            if(args.length >= 1) {
                if(args[0].equalsIgnoreCase("reload")) {
                    UsefulMOTD.plugin.reloadConfig();
                    UsefulMOTD.plugin.getLogger().info(ChatColor.GREEN + "Plugin reloaded!");
                }
            } else {

            }
        }
        return false;
    }
}
