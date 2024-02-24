package me.trae.framework.types;

import me.trae.framework.SpigotManager;
import me.trae.framework.SpigotModule;
import org.bukkit.event.Listener;

public class SpigotListener<M extends SpigotManager> extends SpigotModule<M> implements Listener {

    public SpigotListener(final M manager) {
        super(manager);
    }
}