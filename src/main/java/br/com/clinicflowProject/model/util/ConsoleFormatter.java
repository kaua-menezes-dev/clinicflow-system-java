package br.com.clinicflowProject.model.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class ConsoleFormatter {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    private ConsoleFormatter(){}

    public static String formatDateTime(LocalDateTime value) {
        if (value == null) {
            return "-";
        }

        return value.format(DATE_TIME_FORMATTER);
    }

    public static void title(String text) {
        System.out.println("\n=== " + text + " ===");
    }

    public static void success(String text) {
        System.out.println("SUCESSO: " + text);
    }

    public static void error(String text) {
        System.out.println("ERRO: " + text);
    }

}
