package me.trae.framework.utility;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.util.List;

public class UtilMessage {

    private static String getPrefix(final String prefix) {
        if (prefix == null) {
            return "";
        }

        return ChatColor.BLUE + (prefix + ">") + " " + ChatColor.GRAY;
    }

    public static void log(final String prefix, String message) {
        final ChatColor defaultChatColor = (prefix != null ? ChatColor.GRAY : ChatColor.WHITE);

        for (final ChatColor chatColor : ChatColor.values()) {
            message = message.replaceAll(String.format("<%s>", chatColor.name().toLowerCase()), chatColor.toString());
            message = message.replaceAll(String.format("</%s>", chatColor.name().toLowerCase()), defaultChatColor.toString());
        }

        message = message.replaceAll("<reset>", defaultChatColor.toString());

        Bukkit.getConsoleSender().sendMessage(getPrefix(prefix) + message);
    }
}