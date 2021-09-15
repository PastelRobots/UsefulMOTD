package me.pastelrobots.usefulmotd.utils;

import me.pastelrobots.usefulmotd.UsefulMOTD;

import java.io.*;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class IO {
    private IO() {
        throw new IllegalStateException("Utility class");
    }

    public static void loadFlatfileIntoHashMap(File f, Map<InetAddress, UUID> m) {
        long start = System.currentTimeMillis();
        if (f.exists()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(f));
                String l;
                while ((l = br.readLine()) != null) {
                    String[] t = l.split("=", 2);
                    if (t.length != 2)
                        continue;
                    m.put(InetAddress.getByName(t[0].replaceAll("/", "")), UUID.fromString(t[1]));
                }
                br.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    public static void saveHashMapIntoFlatfile(File f, Map<InetAddress, UUID> m) {
        long start = System.currentTimeMillis();
        try {
            FileOutputStream fos = new FileOutputStream(f);
            fos.flush();
            fos.close();
            PrintWriter pw = new PrintWriter(f);
            for (Map.Entry<InetAddress, UUID> entry : m.entrySet())
                pw.println(String.valueOf(String.valueOf(entry.getKey()).replaceAll("/", "")) + "=" + entry.getValue());
            pw.flush();
            pw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private static <K, V> Map<V, K> invert(Map<K, V> map) {
        Map<V, K> result = new HashMap<>();
        for (Map.Entry<K, V> entry : map.entrySet())
            result.put(entry.getValue(), entry.getKey());
        return result;
    }

    public static void removeUnusedEntries() {
        long start = System.currentTimeMillis();
        int elementsStart = UsefulMOTD.IP_UUID.size();
        UsefulMOTD.IP_UUID = invert(invert(UsefulMOTD.IP_UUID));
        int elementsEnd = UsefulMOTD.IP_UUID.size();
    }

    public static Object getKeyFromValue(Map<?, ?> hm, Object value) {
        for (Object o : hm.keySet()) {
            if (hm.get(o).equals(value))
                return o;
        }
        return null;
    }
}
