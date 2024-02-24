package me.trae.framework.interfaces;

import me.trae.framework.components.PluginComponent;

public interface ISpigotPlugin extends PluginComponent {

    default String getPluginName() {
        return this.getClass().getSimpleName();
    }

    void initializePlugin();

    void shutdownPlugin();
}