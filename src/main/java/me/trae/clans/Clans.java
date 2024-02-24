package me.trae.clans;

import me.trae.clans.clan.ClanManager;
import me.trae.framework.SpigotPlugin;

public class Clans extends SpigotPlugin {

    @Override
    public void registerManagers() {
        addManager(new ClanManager(this));
    }
}