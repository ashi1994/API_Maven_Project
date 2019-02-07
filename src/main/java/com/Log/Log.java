package com.Log;


import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.log4j.Logger;

public class Log {

    /**
     * Writes the log messages. By default it will log all INFO messages only
     *
     * @param className
     *            : holds Class Name to write logs
     *
     * @param message
     *            : Log message.
     */
    public static void writeMessage(String className, String message) {
        writeMessage(LogLevel.DEBUG, className, message);
    }

    /**
     * Write the log messages
     *
     *
     *            : Log Level (DEBUG, ERROR, FATAL, INFO, WARN)
     *
     * @param className
     *            : holds Class Name to write logs
     *
     * @param message
     *            : Log message
     */
    public static void writeMessage(LogLevel logLevel, String className,
                                    String message) {
        logMessage(logLevel, className, message);
    }

    public static void writeMessage(LogLevel logLevel, String message) {
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
            if(LogLevel.ERROR.equals(logLevel)){
                message = message;
            }
        }


    public static void printStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        t.printStackTrace(new PrintWriter(sw));
        writeMessage(LogLevel.ERROR, "Stack trace:\n" + sw.toString());
    }

    /**
     * Create logger and log the message
     *
     * @param
     *            : Log Level
     *
     * @param className
     *            : holds Class Name to write logs
     *
     * @param message
     *            : Log message
     */
    private static void logMessage(LogLevel logLevel, String className,
                                   String message) {
        Logger logger = Logger.getLogger(className);
        try {
            switch (logLevel) {
                case DEBUG:
                    logger.debug(message);
                    break;
                case ERROR:
                    logger.error(message);
                    break;
                case FATAL:
                    logger.fatal(message);
                    break;
                case INFO:
                    logger.info(message);
                    break;
                case WARN:
                    logger.warn(message);
                    break;
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public enum LogLevel {
        DEBUG, ERROR, FATAL, INFO, WARN
    }


}
