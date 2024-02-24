package me.trae.framework;

import me.trae.framework.components.ManagerComponent;
import me.trae.framework.interfaces.ISpigotPlugin;
import me.trae.framework.utility.UtilMessage;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public abstract class SpigotPlugin extends JavaPlugin implements ISpigotPlugin {

    private final LinkedHashMap<String, SpigotManager> MANAGERS = new LinkedHashMap<>();

    @Override
    public LinkedHashMap<String, SpigotManager> getManagers() {
        return this.MANAGERS;
    }

    @Override
    public void initializePlugin() {
        UtilMessage.log(this.getPluginName(), "Plugin Status: <gold>Enabling");

        this.getManagers().values().forEach(ManagerComponent::registerModules);

        for (final SpigotManager manager : this.getManagers().values()) {
            manager.initializeFrame();

            this.alert(manager, true);
        }

        UtilMessage.log(this.getPluginName(), "Plugin Status: <green>Enabled");
    }

    @Override
    public void shutdownPlugin() {
        UtilMessage.log(this.getPluginName(), "Plugin Status: <gold>Disabling");

        for (final SpigotManager manager : this.getManagers().values()) {
            manager.shutdownFrame();

            this.alert(manager, false);
        }

        UtilMessage.log(this.getPluginName(), "Plugin Status: <red>Disabled");
    }

    private void alert(final SpigotManager manager, final boolean initialized) {
        String message = "No modules found.";

        final Collection<SpigotModule<?>> modules = manager.getModules().values();

        if (!(modules.isEmpty())) {
            final String colorType = (initialized ? "<green>" : "<red>");

            final String matches = modules.stream().map(module -> String.format("%s", colorType + module.getName())).collect(Collectors.joining("<gray>,"));

            final String type = (initialized ? "Loaded" : "Un-Loaded");

            message = String.format("%s <yellow>%s</yellow> Modules: [%s<reset>]", type, modules.size(), matches);
        }

        UtilMessage.log(manager.getName(), message);
    }

    @Override
    public void onEnable() {
        this.registerManagers();
        this.initializePlugin();
    }

    @Override
    public void onDisable() {
        this.shutdownPlugin();
    }
}