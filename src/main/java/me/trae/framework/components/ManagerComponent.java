package me.trae.framework.components;

import me.trae.framework.SpigotModule;
import me.trae.framework.utility.UtilFrame;

import java.util.LinkedHashMap;
import java.util.List;

public interface ManagerComponent {

    void registerModules();

    LinkedHashMap<String, SpigotModule<?>> getModules();

    default void addModule(final SpigotModule<?> module) {
        UtilFrame.addFrame(this.getModules(), module);
    }

    default void removeModule(final SpigotModule<?> module) {
        UtilFrame.removeFrame(this.getModules(), module);
    }

    default SpigotModule<?> getModuleByName(final String name) {
        return UtilFrame.getFrameByName(this.getModules(), name);
    }

    default <E extends SpigotModule<?>> E getModuleByClass(final Class<E> clazz) {
        return UtilFrame.getFrameByClass(this.getModules(), clazz);
    }

    default <E extends SpigotModule<?>> List<E> getModulesByClass(final Class<E> clazz) {
        return UtilFrame.getFramesByClass(this.getModules(), clazz);
    }

    default boolean isModuleByName(final String name) {
        return UtilFrame.isFrameByName(this.getModules(), name);
    }

    default boolean hasModules() {
        return UtilFrame.hasFrames(this.getModules());
    }
}