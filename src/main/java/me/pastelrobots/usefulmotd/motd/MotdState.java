package me.pastelrobots.usefulmotd.motd;

public class MotdState {
    private Motd motdBase;

    private Motd motdExtension;

    private static MotdState instance;

    private MotdState() {
        initializeMotds();
    }

    public static MotdState getInstance() {
        if (instance == null)
            instance = new MotdState();
        return instance;
    }

    public Motd getMotdBase() {
        return this.motdBase;
    }

    public Motd getMotdExtension() {
        return this.motdExtension;
    }

    public void initializeMotds() {
        this.motdBase = new NormalMOTD();
        this.motdExtension = null;
    }
}
