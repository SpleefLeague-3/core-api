package com.spleefleague.coreapi.chat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Copied from either net.md_5.bungee.api.ChatColor or the spigot one, can't remember
 *
 * @author NickM13
 * @since 6/14/2020
 */
public enum ChatColor {
    BLACK('0', "black"),
    DARK_BLUE('1', "dark_blue"),
    DARK_GREEN('2', "dark_green"),
    DARK_AQUA('3', "dark_aqua"),
    DARK_RED('4', "dark_red"),
    DARK_PURPLE('5', "dark_purple"),
    GOLD('6', "gold"),
    GRAY('7', "gray"),
    DARK_GRAY('8', "dark_gray"),
    BLUE('9', "blue"),
    GREEN('a', "green"),
    AQUA('b', "aqua"),
    RED('c', "red"),
    LIGHT_PURPLE('d', "light_purple"),
    YELLOW('e', "yellow"),
    WHITE('f', "white"),
    MAGIC('k', "obfuscated"),
    BOLD('l', "bold"),
    STRIKETHROUGH('m', "strikethrough"),
    UNDERLINE('n', "underline"),
    ITALIC('o', "italic"),
    UNDO('u', "undo"),
    RESET('r', "reset");

    public static final String ALL_CODES = "0123456789AaBbCcDdEeFfKkLlMmNnOoRr";
    public static final Pattern STRIP_COLOR_PATTERN = Pattern.compile("(?i)" + String.valueOf('§') + "[0-9A-FK-OR]");
    private static final Map<Character, ChatColor> BY_CHAR = new HashMap();
    private final char code;
    private final String toString;
    private final String name;

    ChatColor(char code, String name) {
        this.code = code;
        this.name = name;
        this.toString = new String(new char[]{'§', code});
    }

    public String toString() {
        return this.toString;
    }

    public static String stripColor(String input) {
        return input == null ? null : STRIP_COLOR_PATTERN.matcher(input).replaceAll("");
    }

    public static String translateAlternateColorCodes(char altColorChar, String textToTranslate) {
        char[] b = textToTranslate.toCharArray();

        for(int i = 0; i < b.length - 1; ++i) {
            if (b[i] == altColorChar && "0123456789AaBbCcDdEeFfKkLlMmNnOoRr".indexOf(b[i + 1]) > -1) {
                b[i] = 167;
                b[i + 1] = Character.toLowerCase(b[i + 1]);
            }
        }

        return new String(b);
    }

    public char getChar() {
        return code;
    }

    public static ChatColor getByChar(char code) {
        return BY_CHAR.get(code);
    }

    public String getName() {
        return this.name;
    }

    static {
        ChatColor[] var0 = values();
        int var1 = var0.length;

        for(int var2 = 0; var2 < var1; ++var2) {
            ChatColor colour = var0[var2];
            BY_CHAR.put(colour.code, colour);
        }

    }

    public static List<ChatColor> getChatColors(String str) {
        List<ChatColor> colors = new ArrayList<>();
        for (int i = 0; i < str.length() - 1; i++) {
            char c = str.charAt(i);
            if (c == '&' || c == '§') {
                c = str.charAt(i + 1);
                if (c >= 'A' && c <= 'Z') {
                    c += 32;
                }
                ChatColor color = ChatColor.getByChar(c);
                if (color != null) {
                    colors.add(color);
                }
            }
        }
        return colors;
    }

}
