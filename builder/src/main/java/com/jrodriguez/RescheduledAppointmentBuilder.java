package com.jrodriguez;

public class RescheduledAppointmentBuilder extends AppointmentBuilder {

    private Appointment originalAppointment;
    private java.sql.Date newDate;
    private java.sql.Time newTime;
    private String newStatus;

    public void setOriginalAppointment(Appointment originalAppointment) {
        this.originalAppointment = originalAppointment;
        if (originalAppointment != null) {
            appointment.setPatient_document(originalAppointment.getPatient_document());
            appointment.setPatient_name(originalAppointment.getPatient_name());
            appointment.setPatient_phone(originalAppointment.getPatient_phone());
            appointment.setProfessional_id(originalAppointment.getProfessional_id());
            appointment.setProfessional_name(originalAppointment.getProfessional_name());
            appointment.setDuration_minutes(originalAppointment.getDuration_minutes());
            appointment.setReason(originalAppointment.getReason());
        }
    }

    @Override
    public void buildPatientDocument(String document) {
        throw new UnsupportedOperationException("No se puede modificar el documento del paciente en reagendamiento");
    }

    @Override
    public void buildPatientName(String name) {
        throw new UnsupportedOperationException("No se puede modificar el nombre del paciente en reagendamiento");
    }

    @Override
    public void buildPatientPhone(String phone) {
        throw new UnsupportedOperationException("No se puede modificar el teléfono del paciente en reagendamiento");
    }

    @Override
    public void buildProfessionalId(Long id) {
        throw new UnsupportedOperationException("No se puede modificar el profesional en reagendamiento");
    }

    @Override
    public void buildProfessionalName(String name) {
        throw new UnsupportedOperationException("No se puede modificar el nombre del profesional en reagendamiento");
    }

    @Override
    public void buildAppointmentDate(java.sql.Date date) {
        this.newDate = date;
        appointment.setAppointment_date(date);
    }

    @Override
    public void buildAppointmentTime(java.sql.Time time) {
        this.newTime = time;
        appointment.setAppointment_time(time);
    }

    @Override
    public void buildDurationMinutes(Integer duration) {
        throw new UnsupportedOperationException("No se puede modificar la duración en reagendamiento");
    }

    @Override
    public void buildReason(String reason) {
        throw new UnsupportedOperationException("No se puede modificar el motivo en reagendamiento");
    }

    @Override
    public void buildStatus(String status) {
        this.newStatus = status;
        appointment.setStatus(status);
    }
}