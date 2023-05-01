package com.config;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Presets {
    static LocalDateTime currentDateTime = LocalDateTime.now();
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static final String ERRORPRESET = "\033[31;49;1m[ERROR] " + currentDateTime.format(formatter)+"\033[39;49m - ";
    public static final String LOGPRESET = "\033[37;49;1m[LOG]] " + currentDateTime.format(formatter)+"\033[39;49m - ";
    public static final String DONEPRESET = "\033[32;49;1m[DONE]] " + currentDateTime.format(formatter)+"\033[39;49m - ";
}
