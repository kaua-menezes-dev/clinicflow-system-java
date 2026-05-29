package br.com.clinicflowProject.model.entity;

import br.com.clinicflowProject.model.enums.PatientStatus;
import br.com.clinicflowProject.model.util.IDGenerator;
import br.com.clinicflowProject.model.util.Validator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class Patient {

    private final String id;
    private final String cpf;
    private String name;
    private LocalDate birthDate;
    private String phone;
    private PatientStatus patientStatus;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Patient(String cpf, String name, String phone, LocalDate dataNascimento) {
        validatePatientData(name, cpf, dataNascimento, phone);
        this.cpf = cpf;
        this.name = name;
        this.birthDate = dataNascimento;
        this.phone = phone;
        this.id = IDGenerator.nextPatientId();
        this.patientStatus = PatientStatus.ACTIVE;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = null;
    }

    public String getPhone() {
        return phone;
    }

    public String getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public PatientStatus getPatientStatus() {
        return patientStatus;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setName(String name) {
        Validator.requireValidTextFormat(name, 3, 100, "Nome do paciente");
        this.name = name;
        this.updatedAt = LocalDateTime.now();
    }

    public void setBirthDate(LocalDate birthDate) {
        Validator.requirePastOrPresentDate(birthDate, "Data de nascimento");
        this.birthDate = birthDate;
        this.updatedAt = LocalDateTime.now();
    }

    public void setPhone(String phone) {
        Validator.requireValidPhoneFormat(phone, "Numero de telefone");
        this.phone = phone;
        this.updatedAt = LocalDateTime.now();
    }

    public void deactivatePatient(){
        patientStatus = PatientStatus.INACTIVE;
        this.updatedAt = LocalDateTime.now();
    }

    public void activePatient(){
        patientStatus = PatientStatus.ACTIVE;
        this.updatedAt = LocalDateTime.now();
    }

    public boolean isActive(){
        return patientStatus == PatientStatus.ACTIVE;
    }

    public int getPatientAge(){
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    private void validatePatientData(String name, String cpf, LocalDate dataNascimento, String phone){
        Validator.requireValidTextFormat(name, 3, 100, "Nome do paciente");
        Validator.requireValidDocumentFormat(cpf, "CPF do paciente");
        Validator.requirePastOrPresentDate(dataNascimento, "Data de nascimento do paciente");
        Validator.requireValidPhoneFormat(phone, "Numero de telefone.");
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + birthDate + " | " + patientStatus;
    }
}
