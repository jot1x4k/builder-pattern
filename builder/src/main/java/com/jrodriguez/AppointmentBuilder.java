package com.jrodriguez;

public abstract class AppointmentBuilder {
    protected Appointment appointment;

    public Appointment getAppointment() {
        return appointment;
    }

    public void createNewAppointment() {
        appointment = new Appointment();
    }

    public abstract void buildPatientDocument(String document);
    public abstract void buildPatientName(String name);
    public abstract void buildPatientPhone(String phone);
    public abstract void buildProfessionalId(Long id);
    public abstract void buildProfessionalName(String name);
    public abstract void buildAppointmentDate(java.sql.Date date);
    public abstract void buildAppointmentTime(java.sql.Time time);
    public abstract void buildDurationMinutes(Integer duration);
    public abstract void buildReason(String reason);
    public abstract void buildStatus(String status);

}
