package me.trae.framework.utility;

import java.util.Arrays;

public class UtilFormat {

    public static String getCharacterByIndex(final String string, final int index) {
        try {
            return String.valueOf(string.charAt(index));
        } catch (final Exception ignored) {
        }

        return "";
    }

    public static String cleanString(String string) {
        string = string.toLowerCase();
        string = string.replaceAll("_", " ");

        final StringBuilder builder = new StringBuilder();

        for (int index = 0; index < string.length(); index++) {
            final String lastCharacter = getCharacterByIndex(string, index - 1);
            String character = getCharacterByIndex(string, index);

            if (index == 0 || lastCharacter.equals(" ")) {
                character = character.toUpperCase();
            }

            builder.append(character);
        }

        return builder.toString();
    }

    public static String sliceString(String string) {
        for (final String character : Arrays.asList("_", " ")) {
            string = string.replaceAll(character, "");
        }

        return string;
    }

    public static String unSliceString(String string) {
        string = sliceString(string);

        final StringBuilder builder = new StringBuilder();

        for (int index = 0; index < string.length(); index++) {
            final String lastCharacter = getCharacterByIndex(string, index - 1);
            final String character = getCharacterByIndex(string, index);
            final String nextCharacter = getCharacterByIndex(string, index + 1);

            if (index > 0 && character.equals(character.toUpperCase()) && (!(nextCharacter.equals(nextCharacter.toUpperCase())) || lastCharacter.equals(lastCharacter.toLowerCase()))) {
                builder.append(" ");
            }

            builder.append(character);
        }

        return builder.toString();
    }
}