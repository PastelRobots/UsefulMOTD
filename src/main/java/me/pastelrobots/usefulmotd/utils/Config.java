package me.pastelrobots.usefulmotd.utils;

import me.pastelrobots.usefulmotd.UsefulMOTD;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.Set;

public final class Config {

    public static int getInt(String intpath) {
        return UsefulMOTD.plugin.getConfig().getInt(intpath);
    }

    public static boolean getBoolean(String booleanpath) {
        return UsefulMOTD.plugin.getConfig().getBoolean(booleanpath);
    }

    public static double getDouble(String doublepath) {
        return UsefulMOTD.plugin.getConfig().getDouble(doublepath);
    }

    public static String getString(String stringpath) {
        return UsefulMOTD.plugin.getConfig().getString(stringpath);
    }

    public static Object getObject(String objectpath, Class<Boolean> clazz) {
        return UsefulMOTD.plugin.getConfig().getObject(objectpath, clazz);
    }

    public static List<Boolean> getBooleanList(String booleanpath) {
        return UsefulMOTD.plugin.getConfig().getBooleanList(booleanpath);
    }

    public static List<String> getStringList(String stringpath) {
        return UsefulMOTD.plugin.getConfig().getStringList(stringpath);
    }

    public static List<Byte> getByteList(String bytepath) {
        return UsefulMOTD.plugin.getConfig().getByteList(bytepath);
    }

    public static List<Character> getCharacterList(String characterpath) {
        return UsefulMOTD.plugin.getConfig().getCharacterList(characterpath);
    }

    public static @Nullable Color getColour(String colourpath) {
        return UsefulMOTD.plugin.getConfig().getColor(colourpath);
    }

    public static List<Double> getDoubleList(String doublepath) {
        return UsefulMOTD.plugin.getConfig().getDoubleList(doublepath);
    }

    public static List<Float> getFloatList(String floatpath) {
        return UsefulMOTD.plugin.getConfig().getFloatList(floatpath);
    }

    public static List<Integer> getIntList(String intpath) {
        return UsefulMOTD.plugin.getConfig().getIntegerList(intpath);
    }

    public static ItemStack getItemStack(String itemstackpath) {
        return UsefulMOTD.plugin.getConfig().getItemStack(itemstackpath);
    }

    public static List getList(String listpath) {
        return UsefulMOTD.plugin.getConfig().getList(listpath);
    }

    public static @Nullable Vector getVector(String vecpath) {
        return UsefulMOTD.plugin.getConfig().getVector(vecpath);
    }

    public static Set<String> getKeys(boolean deep) {
        return UsefulMOTD.plugin.getConfig().getKeys(deep);
    }

    public static Map<String, Object> getValues(boolean deep) {
        return UsefulMOTD.plugin.getConfig().getValues(deep);
    }

    public static List<Short> getShortList(String shortpath) {
        return UsefulMOTD.plugin.getConfig().getShortList(shortpath);
    }

    public static OfflinePlayer getOfflinePlayer(String offlpath) {
        return UsefulMOTD.plugin.getConfig().getOfflinePlayer(offlpath);
    }

    public static List<Map<?, ?>> getMapList(String mappath) {
        return UsefulMOTD.plugin.getConfig().getMapList(mappath);
    }

    public static @NotNull List<Long> getLongList(String longpath) {
        return UsefulMOTD.plugin.getConfig().getLongList(longpath);
    }

    public static Long getLong(String longpath) {
        return UsefulMOTD.plugin.getConfig().getLong(longpath);
    }

    public static @Nullable Location getLocation(String locpath) {
        return UsefulMOTD.plugin.getConfig().getLocation(locpath);
    }

    public static ConfigurationSection getConfigSection(String cspath) {
        return UsefulMOTD.plugin.getConfig().getConfigurationSection(cspath);
    }

}
