package br.com.clinicflowProject.model.exceptions;

public class NotFoundPatientException extends RuntimeException {
    public NotFoundPatientException(String message) {
        super(message);
    }
}
