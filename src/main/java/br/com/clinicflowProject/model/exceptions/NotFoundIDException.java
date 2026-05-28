package br.com.clinicflowProject.model.exceptions;

public class NotFoundIDException extends RuntimeException {
    public NotFoundIDException(String message) {
        super(message);
    }
}
