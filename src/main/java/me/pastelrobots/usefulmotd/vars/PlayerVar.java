package me.pastelrobots.usefulmotd.vars;

import me.pastelrobots.usefulmotd.UsefulMOTD;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

import java.net.InetAddress;

public class PlayerVar {
    private PlayerVar() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean isKnownPlayer(InetAddress ip) {
        if (UsefulMOTD.IP_UUID.containsKey(ip))
            return true;
        return false;
    }

    public static String getNameFromIP(InetAddress ip) {
        OfflinePlayer p = Bukkit.getOfflinePlayer(UsefulMOTD.IP_UUID.get(ip));
        if (p.hasPlayedBefore())
            return p.getName();
        return "<unknown>";
    }
}
