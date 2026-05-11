package com.jrodriguez;

public class SelfServiceAppointmentBuilder extends AppointmentBuilder {

    @Override
    public void buildPatientDocument(String document) {
        appointment.setPatient_document(document);
    }

    @Override
    public void buildPatientName(String name) {
        appointment.setPatient_name(name);
    }

    @Override
    public void buildPatientPhone(String phone) {
        appointment.setPatient_phone(phone);
    }

    @Override
    public void buildProfessionalId(Long id) {
        appointment.setProfessional_id(id);
    }

    @Override
    public void buildProfessionalName(String name) {
        appointment.setProfessional_name(name);
    }

    @Override
    public void buildAppointmentDate(java.sql.Date date) {
        appointment.setAppointment_date(date);
    }

    @Override
    public void buildAppointmentTime(java.sql.Time time) {
        appointment.setAppointment_time(time);
    }

    @Override
    public void buildDurationMinutes(Integer duration) {
        appointment.setDuration_minutes(duration);
    }

    @Override
    public void buildReason(String reason) {
        appointment.setReason(reason);
    }

    @Override
    public void buildStatus(String status) {
        appointment.setStatus("PENDIENTE_AUTOGESTION");
    }

}
