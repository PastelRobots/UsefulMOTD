package me.pastelrobots.usefulmotd.events;

import me.pastelrobots.usefulmotd.motd.MotdState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import java.net.InetAddress;

public class Ping implements Listener {
    @EventHandler
    public void onPing(ServerListPingEvent e) {
        InetAddress ip = e.getAddress();
        MotdState.getInstance().getMotdBase().setMotd(e, ip);
        if (MotdState.getInstance().getMotdExtension() != null)
            MotdState.getInstance().getMotdExtension().setMotd(e, ip);
    }
}
