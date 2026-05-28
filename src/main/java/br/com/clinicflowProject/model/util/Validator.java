package br.com.clinicflowProject.model.util;

import br.com.clinicflowProject.model.exceptions.ValidationException;

import java.time.LocalDate;
import java.time.LocalDateTime;

public final class Validator {

    private Validator() {
    }

    public static void requireNonNull(Object object, String fieldName) {
        if (object == null) {
            throw new ValidationException(fieldName + " não pode ser nulo.");
        }
    }

    public static void requireNonBlank(String value, String fieldName) {
        requireNonNull(value, fieldName);
        if (value.trim().isEmpty()) {
            throw new ValidationException(fieldName + "não pode estar vazio.");
        }
    }

    public static void requireValidTextFormat(String value, int min, int max, String fieldName) {
        requireNonNull(value, fieldName);
        requireNonBlank(value, fieldName);
        if (value.length() < min || value.length() > max) {
            throw new ValidationException(fieldName + " deve conter entre: " + min + " e " + max + " caracteres.");
        }
    }

    public static void requireValidDocumentFormat(String value, String fieldName) {
        requireNonNull(value, fieldName);
        requireNonBlank(value, fieldName);
        if (!value.matches("\\d{11}")) {
            throw new ValidationException(fieldName + " deve conter exatamente 11 digitos.");
        }
    }


    public static void requireValidCrmFormat(String value, String fieldName) {
        requireNonNull(value, fieldName);
        requireNonBlank(value, fieldName);
        if (!value.matches("\\d{6}")) {
            throw new ValidationException(fieldName + " deve conter exatamente 6 digitos.");
        }
    }

    public static void requirePastOrPresentDate(LocalDate date, String fieldName) {
        requireNonNull(date, fieldName);
        if (date.isAfter(LocalDate.now())) {
            throw new ValidationException(fieldName + " não pode estar no futuro.");
        }
    }

    public static void requirePastOrPresentDateTime(LocalDateTime dateTime, String fieldName) {
        requireNonNull(dateTime, fieldName);
        if (dateTime.isAfter(LocalDateTime.now())) {
            throw new ValidationException(fieldName + " não pode estar no futuro.");
        }
    }
}
