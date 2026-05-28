package br.com.clinicflowProject.model.exceptions;

public class NotFoundDoctorException extends RuntimeException {
    public NotFoundDoctorException(String message) {
        super(message);
    }
}
