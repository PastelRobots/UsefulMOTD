package me.pastelrobots.usefulmotd.motd;

import org.bukkit.event.server.ServerListPingEvent;

import java.net.InetAddress;

public interface Motd {
    String getMOTD(InetAddress paramInetAddress);

    String formatMotd(String paramString, InetAddress paramInetAddress);

    void setMotd(ServerListPingEvent paramServerListPingEvent, InetAddress paramInetAddress);
}
