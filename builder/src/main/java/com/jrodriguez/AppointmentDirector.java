package com.jrodriguez;

public class AppointmentDirector {
    private AppointmentBuilder builder;

    public void setBuilder(AppointmentBuilder builder) {
        this.builder = builder;
    }

    public Appointment getAppointment() {
        return builder.getAppointment();
    }

    public void buildManualAppointment(String document, String name, String phone, Long professionalId, String professionalName, java.sql.Date date, java.sql.Time time, Integer duration, String reason, String status) {
        builder.createNewAppointment();
        builder.buildPatientDocument(document);
        builder.buildPatientName(name);
        builder.buildPatientPhone(phone);
        builder.buildProfessionalId(professionalId);
        builder.buildProfessionalName(professionalName);
        builder.buildAppointmentDate(date);
        builder.buildAppointmentTime(time);
        builder.buildDurationMinutes(duration);
        builder.buildReason(reason);
        builder.buildStatus(status);
    }

    public void buildSelfServiceAppointment(String document, String name, String phone) {
        builder.createNewAppointment();
        builder.buildPatientDocument(document);
        builder.buildPatientName(name);
        builder.buildPatientPhone(phone);
    }

    public void buildRescheduledAppointment(java.sql.Date date, java.sql.Time time, String status) {
        builder.createNewAppointment();
        builder.buildAppointmentDate(date);
        builder.buildAppointmentTime(time);
        builder.buildStatus(status);
    }
}
