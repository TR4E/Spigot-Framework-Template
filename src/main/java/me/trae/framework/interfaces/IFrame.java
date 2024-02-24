package me.trae.framework.interfaces;

import me.trae.framework.SpigotPlugin;

public interface IFrame {

    SpigotPlugin getInstance();

    String getName();

    void initializeFrame();

    void shutdownFrame();

    void onInitialize();

    void onShutdown();
}