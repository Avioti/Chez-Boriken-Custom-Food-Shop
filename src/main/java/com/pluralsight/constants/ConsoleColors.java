package com.pluralsight.constants;

/**
 * ANSI color codes for console output in the application.
 * Provides colors and formatting for enhanced visual display.
 */
public class ConsoleColors {
    // Reset
    public static final String RESET = "\033[0m";

    // Regular Colors
    public static final String RED = "\033[0;31m";
    public static final String GREEN = "\033[0;32m";
    public static final String YELLOW = "\033[0;33m";
    public static final String BLUE = "\033[0;34m";
    public static final String PURPLE = "\033[0;35m";
    public static final String CYAN = "\033[0;36m";

    // Bold
    public static final String BOLD = "\033[1m";

    // Bold Colors
    public static final String RED_BOLD = "\033[1;31m";
    public static final String GREEN_BOLD = "\033[1;32m";
    public static final String YELLOW_BOLD = "\033[1;33m";
    public static final String BLUE_BOLD = "\033[1;34m";
    public static final String PURPLE_BOLD = "\033[1;35m";
    public static final String CYAN_BOLD = "\033[1;36m";

    /**
     * Private constructor to prevent instantiation.
     */
    private ConsoleColors() {
        throw new AssertionError("Cannot instantiate constants class");
    }
}