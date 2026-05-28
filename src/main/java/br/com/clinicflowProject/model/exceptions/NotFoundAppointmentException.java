package br.com.clinicflowProject.model.exceptions;

public class NotFoundAppointmentException extends RuntimeException {
    public NotFoundAppointmentException(String message) {
        super(message);
    }
}
