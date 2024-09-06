package me.trae.framework.utility;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class UtilMessage {

    private static String getPrefix(final ChatColor chatColor, final String prefix) {
        if (prefix == null) {
            return "";
        }

        return String.format("%s> %s", chatColor + prefix, ChatColor.GRAY);
    }

    public static void log(final String prefix, String message) {
        final ChatColor resetChatColor = (prefix != null ? ChatColor.GRAY : ChatColor.WHITE);

        message = message.replaceAll("<reset>", resetChatColor.toString());


        for (final ChatColor chatColor : ChatColor.values()) {
            message = message.replaceAll(String.format("<%s>", chatColor.name().toLowerCase()), chatColor.toString());
            message = message.replaceAll(String.format("</%s>", chatColor.name().toLowerCase()), resetChatColor.toString());
        }

        Bukkit.getConsoleSender().sendMessage(getPrefix(ChatColor.BLUE, prefix) + message);
    }
}
