package me.trae.clans.clan;

import me.trae.clans.clan.modules.DisableSaturation;
import me.trae.framework.SpigotManager;
import me.trae.framework.SpigotPlugin;
import me.trae.framework.utility.UtilMessage;

public class ClanManager extends SpigotManager {

    public ClanManager(final SpigotPlugin instance) {
        super(instance);
    }

    @Override
    public void registerModules() {
        addModule(new DisableSaturation(this));

        final String name = this.getInstance().getManagerByClass(ClanManager.class).getModuleByClass(DisableSaturation.class).getName();

        UtilMessage.log("Test", String.format("<green>%s", name));
    }
}