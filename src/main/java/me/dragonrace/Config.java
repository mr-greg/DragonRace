package me.dragonrace;

import io.github.cdimascio.dotenv.Dotenv;

import java.util.Locale;

public class Config {
    private static  final Dotenv dotenv = Dotenv.load();

    public static String get(String key) {
        return dotenv.get(key.toUpperCase());
    }
}
