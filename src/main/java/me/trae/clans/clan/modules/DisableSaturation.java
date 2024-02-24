package me.trae.clans.clan.modules;

import me.trae.clans.clan.ClanManager;
import me.trae.framework.types.SpigotListener;
import me.trae.framework.utility.UtilJava;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class DisableSaturation extends SpigotListener<ClanManager> {

    public DisableSaturation(final ClanManager manager) {
        super(manager);
    }

    private void apply(final Player player) {
        player.setFoodLevel(20);
        player.setSaturation(0.0F);
    }

    @EventHandler
    public void onFoodLevelChange(final FoodLevelChangeEvent event) {
        event.setCancelled(true);

        if (event.getEntity() instanceof Player) {
            this.apply(UtilJava.cast(Player.class, event.getEntity()));
        }
    }

    @EventHandler
    public void onPlayerJoin(final PlayerJoinEvent event) {
        this.apply(event.getPlayer());
    }

    @Override
    public void onInitialize() {
        for (final Player player : Bukkit.getServer().getOnlinePlayers()) {
            this.apply(player);
        }
    }
}