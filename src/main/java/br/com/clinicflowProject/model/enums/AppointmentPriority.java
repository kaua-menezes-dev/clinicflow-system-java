package br.com.clinicflowProject.model.enums;

public enum AppointmentPriority {

    CRITICAL(4),
    MEDIUM(2),
    HIGH(3),
    LOW(1);

    private final int weight;

    AppointmentPriority(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}
