package com.geekbrains.logging;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainApp {
    private static final Logger LOGGER = LogManager.getLogger(MainApp.class);

    public static void main(String[] args) {
        LOGGER.debug("Debug");
        LOGGER.info("Info");
        LOGGER.warn("Warn");
        LOGGER.error("Error");
        LOGGER.fatal("Fatal");
        LOGGER.info("String: {}. ", "Hello,World");
        a();
    }

    public static void a() {
        try {
            throw new RuntimeException("123");
        } catch(RuntimeException e) {
            LOGGER.throwing(Level.ERROR,e);
        }
    }
}
