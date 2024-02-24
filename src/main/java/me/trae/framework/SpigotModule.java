package me.trae.framework;

import me.trae.framework.interfaces.ISpigotModule;
import me.trae.framework.utility.UtilJava;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

public class SpigotModule<M extends SpigotManager> extends Frame implements ISpigotModule<M> {

    private final M manager;

    public SpigotModule(final M manager) {
        super(manager.getInstance());

        this.manager = manager;
    }

    @Override
    public M getManager() {
        return this.manager;
    }

    @Override
    public void initializeFrame() {
        if (this instanceof Listener) {
            Bukkit.getServer().getPluginManager().registerEvents(UtilJava.cast(Listener.class, this), this.getInstance());
        }

        super.initializeFrame();
    }

    @Override
    public void shutdownFrame() {
        if (this instanceof Listener) {
            HandlerList.unregisterAll(UtilJava.cast(Listener.class, this));
        }

        super.shutdownFrame();
    }
}