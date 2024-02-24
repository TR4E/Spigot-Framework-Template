package me.trae.framework.utility;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class UtilJava {

    public static <T> T cast(final Class<T> clazz, final Object object) {
        if ((clazz != null && object != null) && clazz.isInstance(object)) {
            try {
                return clazz.cast(object);
            } catch (final Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}