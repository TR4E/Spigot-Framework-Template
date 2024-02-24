package me.trae.framework.interfaces;

import me.trae.framework.SpigotManager;

public interface ISpigotModule<M extends SpigotManager> {

    M getManager();
}