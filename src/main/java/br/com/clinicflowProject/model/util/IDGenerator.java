package br.com.clinicflowProject.model.util;

public class IDGenerator {

    private static int doctorSequence = 1;
    private static int patientSequence = 1;
    private static int appointmentSequence = 1;

    private IDGenerator(){}

    public static String nextDoctorId(){
        return String.format("Doc-%04d", doctorSequence++);
    }

    public static String nextPatientId(){
        return String.format("Pat-%04d", patientSequence++);
    }

    public static String nextAppointmentId(){
        return String.format("Appt-%04d", appointmentSequence++);
    }

}
