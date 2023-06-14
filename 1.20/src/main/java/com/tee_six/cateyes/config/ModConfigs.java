package com.tee_six.cateyes.config;

import com.mojang.datafixers.util.Pair;

public class ModConfigs {
    public static SimpleConfig CONFIG;
    private static ModConfigProvider configs;

    public static boolean DARKNESS_IMMUNITY;
    public static boolean BLINDNESS_IMMUNITY;
    public static boolean ACTIVATED;

    public static void registerConfigs() {
        configs = new ModConfigProvider();
        createConfigs();

        CONFIG = SimpleConfig.of("CatEyes_config").provider(configs).request();

        assignConfigs();
    }

    private static void createConfigs() {
        configs.addKeyValuePair(new Pair<>("Darkness_Immunity", true), "true/false");
        configs.addKeyValuePair(new Pair<>("Blindness_Immunity", true), "true/false");
        configs.addKeyValuePair(new Pair<>("Activated", false), "true/false");
    }

    private static void assignConfigs() {
        DARKNESS_IMMUNITY = CONFIG.getOrDefault("Darkness_Immunity", true);
        BLINDNESS_IMMUNITY = CONFIG.getOrDefault("Blindness_Immunity", true);
        ACTIVATED = CONFIG.getOrDefault("Activated", false);
    }
}