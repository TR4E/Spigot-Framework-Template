package me.trae.framework;

import me.trae.framework.interfaces.ISpigotManager;

import java.util.LinkedHashMap;

public abstract class SpigotManager extends Frame implements ISpigotManager {

    private final LinkedHashMap<String, SpigotModule<?>> MODULES = new LinkedHashMap<>();

    public SpigotManager(final SpigotPlugin instance) {
        super(instance);
    }

    @Override
    public LinkedHashMap<String, SpigotModule<?>> getModules() {
        return this.MODULES;
    }

    @Override
    public void initializeFrame() {
        this.getModules().values().forEach(SpigotModule::initializeFrame);

        super.initializeFrame();
    }

    @Override
    public void shutdownFrame() {
        this.getModules().values().forEach(SpigotModule::shutdownFrame);

        super.shutdownFrame();
    }
}