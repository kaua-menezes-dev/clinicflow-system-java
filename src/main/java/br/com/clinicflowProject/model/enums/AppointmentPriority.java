package br.com.clinicflowProject.model.enums;

public enum AppointmentPriority {

    LOW(72),
    MEDIUM(48),
    HIGH(24),
    CRITICAL(8);

    private final int hours;

    AppointmentPriority(int hours) {
        this.hours = hours;
    }

    public int getHours() {
        return hours;
    }
}
