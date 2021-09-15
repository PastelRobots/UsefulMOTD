package me.pastelrobots.usefulmotd.hooks;

import me.pastelrobots.usefulmotd.UsefulMOTD;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;

public class VaultHook {
    private VaultHook() {
        throw new IllegalStateException("Utility class");
    }

    public static Economy econ = null;

    public static boolean setupEconomy() {
        if (Bukkit.getPluginManager().getPlugin("Vault") == null) {
            UsefulMOTD.plugin.getLogger().warning("[ServerlistMOTD] Couldn't find Vault. No %money%!");
            return false;
        }
        UsefulMOTD.plugin.getLogger().info("Hooking into Vault.");
        RegisteredServiceProvider<Economy> rsp = Bukkit.getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            UsefulMOTD.plugin.getLogger().warning("Couldn't find Vault!");
            return false;
        }
        econ = (Economy)rsp.getProvider();
        UsefulMOTD.plugin.getLogger().info("Using " + econ + " via Vault.");
        return (econ != null);
    }

    public static Economy getEcononomy() {
        return econ;
    }
}
