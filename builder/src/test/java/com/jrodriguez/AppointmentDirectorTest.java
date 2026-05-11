package com.jrodriguez;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.sql.Time;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentDirectorTest {

    private AppointmentDirector director;

    @BeforeEach
    void setUp() {
        director = new AppointmentDirector();
    }

    @Test
    void testBuildManualAppointment() {
        AppointmentBuilder builder = new ManualAppointmentBuilder();
        director.setBuilder(builder);

        Date date = Date.valueOf("2023-10-25");
        Time time = Time.valueOf("10:00:00");

        Appointment appointment = director.buildManualAppointment(
                "12345678", "Juan Perez", "555-1234",
                1L, "Dr. Smith", date, time, 30, "Checkup", "CONFIRMED"
        );

        assertNotNull(appointment);
        assertEquals("12345678", appointment.getPatient_document());
        assertEquals("Juan Perez", appointment.getPatient_name());
        assertEquals("555-1234", appointment.getPatient_phone());
        assertEquals(1L, appointment.getProfessional_id());
        assertEquals("Dr. Smith", appointment.getProfessional_name());
        assertEquals(date, appointment.getAppointment_date());
        assertEquals(time, appointment.getAppointment_time());
        assertEquals(30, appointment.getDuration_minutes());
        assertEquals("Checkup", appointment.getReason());
        assertEquals("CONFIRMED", appointment.getStatus());
    }

    @Test
    void testBuildSelfServiceAppointment() {
        AppointmentBuilder builder = new SelfServiceAppointmentBuilder();
        director.setBuilder(builder);

        Date date = Date.valueOf("2023-11-01");
        Time time = Time.valueOf("14:30:00");

        Appointment appointment = director.buildSelfServiceAppointment(
                "87654321", "Maria Lopez", "555-4321", date, time
        );

        assertNotNull(appointment);
        assertEquals("87654321", appointment.getPatient_document());
        assertEquals("Maria Lopez", appointment.getPatient_name());
        assertEquals("555-4321", appointment.getPatient_phone());
        assertEquals(date, appointment.getAppointment_date());
        assertEquals(time, appointment.getAppointment_time());
        assertEquals("PENDIENTE_AUTOGESTION", appointment.getStatus());

        // Verify that fields not set by self-service are null
        assertNull(appointment.getProfessional_id());
        assertNull(appointment.getProfessional_name());
        assertNull(appointment.getDuration_minutes());
        assertNull(appointment.getReason());
    }

    @Test
    void testBuildRescheduledAppointment() {
        Appointment originalAppointment = new Appointment();
        originalAppointment.setPatient_document("11112222");
        originalAppointment.setPatient_name("Carlos Ruiz");
        
        AppointmentBuilder builder = new RescheduledAppointmentBuilder(originalAppointment);
        
        director.setBuilder(builder);

        Date newDate = Date.valueOf("2023-12-15");
        Time newTime = Time.valueOf("09:00:00");

        Appointment appointment = director.buildRescheduledAppointment(newDate, newTime);

        assertNotNull(appointment);
        assertEquals("11112222", appointment.getPatient_document());
        assertEquals("Carlos Ruiz", appointment.getPatient_name());
        assertEquals(newDate, appointment.getAppointment_date());
        assertEquals(newTime, appointment.getAppointment_time());
        assertEquals("REPROGRAMADA", appointment.getStatus());
    }
}
