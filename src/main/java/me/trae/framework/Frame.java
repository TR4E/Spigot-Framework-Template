package me.trae.framework;

import me.trae.framework.interfaces.IFrame;
import me.trae.framework.utility.UtilFormat;

public class Frame implements IFrame {

    private final SpigotPlugin instance;
    private final String name;

    public Frame(final SpigotPlugin instance) {
        this.instance = instance;
        this.name = UtilFormat.unSliceString(this.getClass().getSimpleName());
    }

    @Override
    public SpigotPlugin getInstance() {
        return this.instance;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void initializeFrame() {
        this.onInitialize();
    }

    @Override
    public void shutdownFrame() {
        this.onShutdown();
    }

    @Override
    public void onInitialize() {
    }

    @Override
    public void onShutdown() {
    }
}