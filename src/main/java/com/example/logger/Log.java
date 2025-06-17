package com.example.logger;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.spi.ExtendedLogger;

/**
 * Lightweight Log4j‑2 façade that:
 * • Preserves the caller’s class/method/line in log output
 * • Provides both simple and parameterized logging methods
 * <p>
 * Usage examples
 * Log.info("Simple message");
 * Log.info("User {} logged in from {}", userId, ipAddress);
 * Log.error("Failed to save order {}", orderId, ex);
 *
 * @author Pabitra Swain (pabitra.swain.work@gmail.com)
 */
@SuppressWarnings("unused")
public final class Log {

    /**
     * Fully‑qualified name of this façade, used so Log4j2 can skip it in the stack trace.
     */
    private static final String FQCN = Log.class.getName();

    /**
     * Shared underlying logger (package name isn’t important because we supply FQCN).
     */
    private static final ExtendedLogger LOGGER =
            (ExtendedLogger) LogManager.getLogger();

    private Log() { /* utility class — no instances */ }

    /* ───────────────────────── Info ───────────────────────── */

    public static void info(String message) {
        LOGGER.logIfEnabled(FQCN, Level.INFO, null, message);
    }

    /**
     * Parameterised version: use `{}` placeholders in the message.
     */
    public static void info(String message, Object... params) {
        LOGGER.logIfEnabled(FQCN, Level.INFO, null, message, params);
    }

    /* ───────────────────────── Warn ───────────────────────── */

    public static void warn(String message) {
        LOGGER.logIfEnabled(FQCN, Level.WARN, null, message);
    }

    public static void warn(String message, Object... params) {
        LOGGER.logIfEnabled(FQCN, Level.WARN, null, message, params);
    }

    /* ───────────────────────── Error ───────────────────────── */

    public static void error(String message) {
        LOGGER.logIfEnabled(FQCN, Level.ERROR, null, message);
    }

    public static void error(String message, Throwable t) {
        LOGGER.logIfEnabled(FQCN, Level.ERROR, null, message, t);
    }

    public static void error(String message, Throwable t, Object... params) {
        LOGGER.logIfEnabled(FQCN, Level.ERROR, null, message, params, t);
    }

    /* ───────────────────────── Fatal ───────────────────────── */

    public static void fatal(String message) {
        LOGGER.logIfEnabled(FQCN, Level.FATAL, null, message);
    }

    /* ───────────────────────── Debug ───────────────────────── */

    public static void debug(String message) {
        LOGGER.logIfEnabled(FQCN, Level.DEBUG, null, message);
    }

    public static void debug(String message, Object... params) {
        LOGGER.logIfEnabled(FQCN, Level.DEBUG, null, message, params);
    }
}
