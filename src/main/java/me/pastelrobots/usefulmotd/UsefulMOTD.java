package me.pastelrobots.usefulmotd;

import com.tchristofferson.configupdater.ConfigUpdater;
import me.pastelrobots.usefulmotd.events.LogIP;
import me.pastelrobots.usefulmotd.events.Ping;
import me.pastelrobots.usefulmotd.hooks.VaultHook;
import me.pastelrobots.usefulmotd.utils.Config;
import me.pastelrobots.usefulmotd.utils.IO;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.*;

public final class UsefulMOTD extends JavaPlugin implements Listener {
    private File customConfigFile;
    private FileConfiguration customConfig;
    public static Plugin plugin;
    private final Set<String> commands = this.getDescription().getCommands().keySet();
    public static Map<InetAddress, UUID> IP_UUID = new HashMap<>();
    private final File loggedIPs = new File("plugins/UsefulMOTD/IP_UUID.dat");


    @Override
    public void onEnable() {
        plugin = this;
        createCustomConfig();
        saveDefaultConfig();
        File configFile = new File(getDataFolder(), "config.yml");

        try {
            ConfigUpdater.update(plugin, "config.yml", configFile, Collections.emptyList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        reloadConfig();
        IO.loadFlatfileIntoHashMap(this.loggedIPs, IP_UUID);
        VaultHook.setupEconomy();
        BukkitScheduler scheduler = getServer().getScheduler();
        Bukkit.getServer().getPluginManager().registerEvents(new Ping(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new LogIP(), this);
        scheduler.runTaskTimerAsynchronously(this, () -> IO.saveHashMapIntoFlatfile(UsefulMOTD.this.loggedIPs, UsefulMOTD.IP_UUID),30L * 1200L, 30L * 1200L);

        if (Config.getBoolean("console.enabled-msg")) {
            Bukkit.getLogger().info(ChatColor.GOLD + "=============================================");
            Bukkit.getLogger().info(ChatColor.GREEN + "UsefulMOTD has been turned on!");
            Bukkit.getLogger().info(ChatColor.GREEN + "If you need help or support join the" + ChatColor.BLUE + " discord.");
            Bukkit.getLogger().info(ChatColor.BLUE + "discord.gg/VtgcZRnmMR");
            Bukkit.getLogger().info(ChatColor.GOLD + "=============================================");
        }
    }

    @Override
    public void onDisable() {
        if (Config.getBoolean("console.enabled-msg")) {
            Bukkit.getLogger().info(ChatColor.RED + "=============================================");
            Bukkit.getLogger().info(ChatColor.BLUE + "UsefulMOTD has been turned off!");
            Bukkit.getLogger().info(ChatColor.BLUE + "If you need help or support join the" + ChatColor.BLUE + " discord.");
            Bukkit.getLogger().info(ChatColor.DARK_BLUE + "discord.gg/VtgcZRnmMR");
            Bukkit.getLogger().info(ChatColor.BLUE + "Bye-bye!");
            Bukkit.getLogger().info(ChatColor.RED + "=============================================");
        }
        IO.removeUnusedEntries();
        IO.saveHashMapIntoFlatfile(this.loggedIPs, IP_UUID);
    }

    public FileConfiguration getCustomConfig() {
        return this.customConfig;
    }

    private void createCustomConfig () {
        customConfigFile = new File(getDataFolder(), "config.yml");
        if (!customConfigFile.exists()) {
            customConfigFile.getParentFile().mkdirs();
            saveResource("config.yml", false);
        }

        customConfig = new YamlConfiguration();
        try {
            customConfig.load(customConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

}
