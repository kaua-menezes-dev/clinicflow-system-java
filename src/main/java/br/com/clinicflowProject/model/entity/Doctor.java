package br.com.clinicflowProject.model.entity;

import br.com.clinicflowProject.model.enums.DoctorArea;
import br.com.clinicflowProject.model.enums.DoctorStatus;
import br.com.clinicflowProject.model.exceptions.InvalidStatusChangeException;
import br.com.clinicflowProject.model.util.IDGenerator;
import br.com.clinicflowProject.model.util.Validator;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Doctor {

    private final String id;
    private String name;
    private final String crm;
    private DoctorArea doctorArea;
    private DoctorStatus doctorStatus;
    private LocalTime entry;
    private LocalTime exit;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Doctor(String name, String crm, DoctorArea doctorArea, LocalTime entry, LocalTime exit) {
        validateDataDoctor(name, crm, doctorArea, entry, exit);
        this.name = name;
        this.doctorArea = doctorArea;
        this.entry = entry;
        this.exit = exit;
        this.id = IDGenerator.nextDoctorId();
        this.crm = crm;
        this.doctorStatus = DoctorStatus.ACTIVE;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = null;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCrm() {
        return crm;
    }

    public DoctorArea getDoctorArea() {
        return doctorArea;
    }

    public DoctorStatus getDoctorStatus() {
        return doctorStatus;
    }

    public LocalTime getEntry() {
        return entry;
    }

    public LocalTime getExit() {
        return exit;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setName(String name) {
        Validator.requireValidTextFormat(name, 3, 100, "Nome do medico");
        this.name = name;
        this.updatedAt = LocalDateTime.now();
    }

    public void setDoctorArea(DoctorArea doctorArea) {
        Validator.requireNonNull(doctorArea, "Area do medico");
        this.doctorArea = doctorArea;
        this.updatedAt = LocalDateTime.now();
    }

    public void setExit(LocalTime exit) {
        Validator.requireEntryAndExit(getEntry(), exit, "Data/hora de saida");
        this.exit = exit;
        this.updatedAt = LocalDateTime.now();
    }

    public void setEntry(LocalTime entry) {
        Validator.requireEntryAndExit(entry, getExit(), "Data/hora de ");
        this.entry = entry;
        this.updatedAt = LocalDateTime.now();
    }

    public boolean isActive() {
        return doctorStatus == DoctorStatus.ACTIVE;
    }

    public void deactivateDoctor() {
        if (!isActive()) {
            throw new InvalidStatusChangeException("Medico já está inativo no sistema.");
        }
        doctorStatus = DoctorStatus.INACTIVE;
        this.updatedAt = LocalDateTime.now();
    }

    public void activateDoctor() {
        if (isActive()) {
            throw new InvalidStatusChangeException("Medico já está ativo no sistema.");
        }
        doctorStatus = DoctorStatus.ACTIVE;
        this.updatedAt = LocalDateTime.now();
    }

    private void validateDataDoctor(String name, String crm, DoctorArea doctorArea, LocalTime entry, LocalTime exit) {
        Validator.requireNonBlank(name, "Nome do medico");
        Validator.requireValidCrmFormat(crm, "CRM do medico");
        Validator.requireNonNull(doctorArea, "Area do medico");
        Validator.requireEntryAndExit(entry, exit, "Data/hora de saida");
    }

}
