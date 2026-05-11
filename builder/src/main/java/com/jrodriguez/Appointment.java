package com.jrodriguez;

import java.sql.Date;
import java.sql.Time;

public class Appointment {

    private String patient_document;
    private String patient_name;
    private String patient_phone;
    private Long professional_id;
    private String professional_name;
    private Date appointment_date;
    private Time appointment_time;
    private Integer duration_minutes;
    private String reason;
    private String status;

    public void setPatient_document(String patient_document) {
        this.patient_document = patient_document;
    }
    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }
    public void setPatient_phone(String patient_phone) {
        this.patient_phone = patient_phone;
    }
    public void setProfessional_id(Long professional_id) {
        this.professional_id = professional_id;
    }
    public void setProfessional_name(String professional_name) {
        this.professional_name = professional_name;
    }
    public void setAppointment_date(Date appointment_date) {
        this.appointment_date = appointment_date;
    }
    public void setAppointment_time(Time appointment_time) {
        this.appointment_time = appointment_time;
    }
    public void setDuration_minutes(Integer duration_minutes) {
        this.duration_minutes = duration_minutes;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }
    public void setStatus(String status) {
        this.status = status;
    }


    public String toString() {
        return "Appointment{" +
                "patient_document='" + patient_document + '\'' +
                ", patient_name='" + patient_name + '\'' +
                ", patient_phone='" + patient_phone + '\'' +
                ", professional_id=" + professional_id +
                ", professional_name='" + professional_name + '\'' +
                ", appointment_date=" + appointment_date +
                ", appointment_time=" + appointment_time +
                ", duration_minutes=" + duration_minutes +
                ", reason='" + reason + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
    
}
