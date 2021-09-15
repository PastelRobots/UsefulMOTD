package me.pastelrobots.usefulmotd.events;

import me.pastelrobots.usefulmotd.UsefulMOTD;
import me.pastelrobots.usefulmotd.utils.IO;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

public class LogIP implements Listener {
    @EventHandler
    public void onPreLogin(AsyncPlayerPreLoginEvent e) {
        if (!UsefulMOTD.IP_UUID.containsKey(e.getAddress()))
            if (IO.getKeyFromValue(UsefulMOTD.IP_UUID, e.getUniqueId()) != null) {
                UsefulMOTD.IP_UUID.remove(IO.getKeyFromValue(UsefulMOTD.IP_UUID, e.getUniqueId()));
                UsefulMOTD.IP_UUID.put(e.getAddress(), e.getUniqueId());
            } else {
                UsefulMOTD.IP_UUID.put(e.getAddress(), e.getUniqueId());
            }
    }
}
