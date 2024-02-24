package me.trae.framework.utility;

import me.trae.framework.Frame;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class UtilFrame {

    public static <F extends Frame> void addFrame(final LinkedHashMap<String, F> map, final F frame) {
        map.put(frame.getClass().getSimpleName().toUpperCase(), frame);
    }

    public static <F extends Frame> void removeFrame(final LinkedHashMap<String, F> map, final F frame) {
        map.remove(frame.getClass().getSimpleName().toUpperCase());
    }

    public static <F extends Frame> F getFrameByName(final LinkedHashMap<String, F> map, final String name) {
        return map.getOrDefault(UtilFormat.sliceString(name).toUpperCase(), null);
    }

    public static <F extends Frame, E extends F> E getFrameByClass(final LinkedHashMap<String, F> map, final Class<E> clazz) {
        return UtilJava.cast(clazz, getFrameByName(map, clazz.getSimpleName()));
    }

    public static <F extends Frame, E extends F> List<E> getFramesByClass(final LinkedHashMap<String, F> map, final Class<E> clazz) {
        final List<E> list = new ArrayList<>();

        for (final F frame : map.values()) {
            if (!(clazz.isInstance(frame))) {
                continue;
            }

            list.add(UtilJava.cast(clazz, frame));
        }

        return list;
    }

    public static <F extends Frame> boolean isFrameByName(final LinkedHashMap<String, F> map, final String name) {
        return map.containsKey(UtilFormat.sliceString(name).toUpperCase());
    }

    public static <F extends Frame> boolean hasFrames(final LinkedHashMap<String, F> map) {
        return !(map.isEmpty());
    }
}