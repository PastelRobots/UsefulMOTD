package me.pastelrobots.usefulmotd.motd;

import me.pastelrobots.usefulmotd.UsefulMOTD;
import me.pastelrobots.usefulmotd.utils.Config;
import me.pastelrobots.usefulmotd.vars.MoneyVar;
import me.pastelrobots.usefulmotd.vars.PlayerVar;
import org.bukkit.ChatColor;
import org.bukkit.event.server.ServerListPingEvent;

import java.net.InetAddress;

public class NormalMOTD implements Motd {
    public String getMOTD(InetAddress ip) {
        if (UsefulMOTD.IP_UUID.containsKey(ip)) {
            return UsefulMOTD.plugin.getConfig().getString("modules.motd.normalmotds.regularmotd.message");
        }
        return UsefulMOTD.plugin.getConfig().getString("modules.motd.normalmotds.newplayermotd.message");
    }

    @Override
    public String formatMotd(String motd, InetAddress ip) {
        String changedMotd;
        if (PlayerVar.isKnownPlayer(ip)) {
            String firstLine = Config.getString("modules.motd.normalmotds.regularmotd.1st-line");
            firstLine = ChatColor.translateAlternateColorCodes('&', firstLine);
            String secondLine = Config.getString("modules.motd.normalmotds.regularmotd.2nd-line");
            secondLine = ChatColor.translateAlternateColorCodes('&', secondLine);
            firstLine = firstLine
                    .replace("%player%", PlayerVar.getNameFromIP(ip))
                    .replace("%vault_bal%", String.valueOf(MoneyVar.getMoney(ip)));
            secondLine = secondLine
                    .replace("%player%", PlayerVar.getNameFromIP(ip))
                    .replace("%vault_bal%", String.valueOf(MoneyVar.getMoney(ip)));
            firstLine = centerText(firstLine, 45);
            secondLine = centerText(secondLine, 45);
            changedMotd = firstLine + " \n"+ secondLine;
        } else {
            String firstLine = Config.getString("modules.motd.normalmotds.newplayermotd.1st-line");
            firstLine = ChatColor.translateAlternateColorCodes('&', firstLine);
            String secondLine = Config.getString("modules.motd.normalmotds.newplayermotd.2nd-line");
            secondLine = ChatColor.translateAlternateColorCodes('&', secondLine);
            firstLine = centerText(firstLine, 45);
            secondLine = centerText(secondLine, 45);
            changedMotd = firstLine + " \n"+ secondLine;
        }
        return changedMotd;
    }

    @Override
    public void setMotd(ServerListPingEvent e, InetAddress ip) {
        e.setMotd(formatMotd(getMOTD(ip), ip));
    }

    public static String centerText(final String text, final double lineLength) {
        final char[] chars = text.toCharArray();
        boolean isBold = false;
        double length = 0.0;
        ChatColor pholder = null;
        for (int i = 0; i < chars.length; ++i) {
            if (chars[i] == '§' && chars.length != i + 1 && (pholder = ChatColor.getByChar(chars[i + 1])) != null) {
                if (pholder != ChatColor.UNDERLINE && pholder != ChatColor.ITALIC && pholder != ChatColor.STRIKETHROUGH && pholder != ChatColor.MAGIC) {
                    isBold = (chars[i + 1] == 'l');
                }
                ++i;
            }
            else {
                ++length;
                if (isBold) {
                    length += 0.1555555555555556;
                }
            }
        }
        final double spaces = (lineLength - length) / 2.0;
        final StringBuilder builder = new StringBuilder();
        for (int j = 0; j < spaces; ++j) {
            builder.append(' ');
        }
        final String copy = builder.toString();
        builder.append(text).append(copy);
        return builder.toString();
    }
}
