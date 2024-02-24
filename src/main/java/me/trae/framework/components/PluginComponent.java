package me.trae.framework.components;

import me.trae.framework.SpigotManager;
import me.trae.utility.UtilFrame;

import java.util.LinkedHashMap;
import java.util.List;

public interface PluginComponent {

    void registerManagers();

    LinkedHashMap<String, SpigotManager> getManagers();

    default void addManager(final SpigotManager manager) {
        UtilFrame.addFrame(this.getManagers(), manager);
    }

    default void removeManager(final SpigotManager manager) {
        UtilFrame.removeFrame(this.getManagers(), manager);
    }

    default SpigotManager getManagerByName(final String name) {
        return UtilFrame.getFrameByName(this.getManagers(), name);
    }

    default <E extends SpigotManager> E getManagerByClass(final Class<E> clazz) {
        return UtilFrame.getFrameByClass(this.getManagers(), clazz);
    }

    default <E extends SpigotManager> E getManagerByTypeClass(final Class<E> clazz) {
        return UtilFrame.getFrameByTypeClass(this.getManagers(), clazz);
    }

    default <E extends SpigotManager> List<E> getManagersByClass(final Class<E> clazz) {
        return UtilFrame.getFramesByClass(this.getManagers(), clazz);
    }

    default boolean isManagerByName(final String name) {
        return UtilFrame.isFrameByName(this.getManagers(), name);
    }

    default boolean hasManagers() {
        return UtilFrame.hasFrames(this.getManagers());
    }
}