package com.epam.university.java.core.utils.common;

import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;

/**
 * Class implements simple logging features.
 *
 * @author Mavropulo Konstantin
 */
public class Logger {
    private PrintWriter printWriter;
    private Instant startTimeStamp;
    private File loggerFile;
    private FileChooser fileChooser;
    private boolean isLogToFileOn;

    /**
     * Initialising logging to the file.
     *
     * @param fileChooser class to select the file by location
     * @throws IllegalArgumentException if parameter is null
     */
    public Logger(FileChooser fileChooser) {
        Validator.validateNotNull(fileChooser,
                Validator.MESSAGE_FOR_SOURCE_IF_NULL);
        try {
            loggerFile = fileChooser.openFile("Please, create new "
                    + "file for logging...", new FileNameExtensionFilter(
                    "Please,use txt extension...",
                    "txt"));
            printWriter = new PrintWriter(loggerFile);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Initialize logger without logging to file feature.
     */
    public Logger() {
    }

    /**
     * Initialising the logging to the file.
     *
     * @param fileChooser class to select the file by location
     * @throws IllegalArgumentException if parameter is null
     */
    public void initializeLogToFile(FileChooser fileChooser) {
        Validator.validateNotNull(fileChooser,
                Validator.MESSAGE_FOR_SOURCE_IF_NULL);
        this.fileChooser = fileChooser;
        isLogToFileOn = true;
        try {
            loggerFile = this.fileChooser.openFile("Please, create new "
                    + "file for logging...", new FileNameExtensionFilter(
                    "Please,use txt extension...",
                    "txt"));
            printWriter = new PrintWriter(loggerFile);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Get start's time stamp.
     *
     * @return <code>Instant</code> - the start's time stamp
     */

    public Instant getStartTimeStamp() {
        return startTimeStamp;
    }

    /**
     * Get file for logging.
     *
     * @return <code>File</code> - file for logging
     */
    public File getLoggerFile() {
        return loggerFile;
    }

    /**
     * Set file for logging.
     *
     * @param loggerFile file for logging
     * @throws IllegalArgumentException if parameter is null
     */
    public void setLoggerFile(File loggerFile) {
        Validator.validateNotNull(loggerFile,
                Validator.MESSAGE_FOR_SOURCE_IF_NULL);
        this.loggerFile = loggerFile;
    }

    /**
     * Add log.
     *
     * @param loggerLine     message for log's line
     * @param isFileLoggerOn true if logging to file is needed, else logging
     *                       only to the IDE panel
     * @throws IllegalArgumentException if <code>loggerLine</code> is null
     */
    public void addLoggerLine(String loggerLine, boolean isFileLoggerOn) {
        Validator.validateNotNull(loggerLine,
                Validator.MESSAGE_FOR_SOURCE_IF_NULL);
        if (isFileLoggerOn) {
            if (!isLogToFileOn) {
                initializeLogToFile(new FileChooser());
            } else {
                printWriter.println(LocalDateTime.now() + ": " + loggerLine);
                printWriter.flush();
                System.out.println(LocalDateTime.now() + ": " + loggerLine);
            }
        } else {
            System.out.println(LocalDateTime.now() + ": " + loggerLine);
        }
    }

    /**
     * Add log with start's stopwatch timestamp.
     *
     * @param loggerLine     message for log's line
     * @param isFileLoggerOn true if logging to file is needed, else logging
     *                       only to the IDE panel
     * @throws IllegalArgumentException if <code>loggerLine</code> is null
     */
    public void startStopwatch(String loggerLine, boolean isFileLoggerOn) {
        Validator.validateNotNull(loggerLine,
                Validator.MESSAGE_FOR_SOURCE_IF_NULL);
        if (isFileLoggerOn) {
            if (!isLogToFileOn) {
                initializeLogToFile(new FileChooser());
            } else {
                startTimeStamp = Instant.now();
                printWriter.println(loggerLine + ": " + startTimeStamp);
                printWriter.flush();
                System.out.println(loggerLine + ": " + startTimeStamp);
            }
        } else {
            startTimeStamp = Instant.now();
            System.out.println(loggerLine + ": " + startTimeStamp);
        }
    }

    /**
     * Add log with finish's stopwatch timestamp.
     *
     * @param loggerLine     message for log's line
     * @param isFileLoggerOn true if logging to file is needed, else logging
     *                       only to the IDE panel
     * @throws IllegalArgumentException if <code>loggerLine</code> is null
     */
    public void stopStopwatch(String loggerLine, boolean isFileLoggerOn) {
        Validator.validateNotNull(loggerLine,
                Validator.MESSAGE_FOR_SOURCE_IF_NULL);
        if (isFileLoggerOn) {
            if (!isLogToFileOn) {
                initializeLogToFile(new FileChooser());
            } else {
                long elapsedTime = Duration.between(Instant.now(), startTimeStamp)
                        .getNano();
                printWriter.println(loggerLine + ": " + elapsedTime);
                printWriter.flush();
                System.out.println(loggerLine + ": " + elapsedTime);
            }
        } else {
            long elapsedTime = Duration.between(Instant.now(), startTimeStamp)
                    .getNano();
            System.out.println(loggerLine + ": " + elapsedTime);
        }
    }
}