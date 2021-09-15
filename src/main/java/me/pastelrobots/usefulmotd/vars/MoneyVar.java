package me.pastelrobots.usefulmotd.vars;

import me.pastelrobots.usefulmotd.UsefulMOTD;
import me.pastelrobots.usefulmotd.hooks.VaultHook;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

import java.net.InetAddress;

public class MoneyVar {
    private MoneyVar() {
        throw new IllegalStateException("Utility class");
    }

    public static Double getMoney(InetAddress ip) {
        try {
            OfflinePlayer p = Bukkit.getOfflinePlayer(UsefulMOTD.IP_UUID.get(ip));
            if (p.hasPlayedBefore())
                return VaultHook.getEcononomy().getBalance(p);
            return 0.0D;
        } catch (NullPointerException npe) {
            return -1.0D;
        } catch (NoClassDefFoundError nc) {
            return 0.0D;
        }
    }
}
