package com.jrodriguez;

public class Main {
    public static void main(String[] args) {

        Appointment manualAppointment = new Appointment();
        Appointment selfServiceAppointment = new Appointment();
        Appointment rescheduledAppointment = new Appointment();


        System.out.println("================================================================================");
        System.out.println("Patron Builder - Ejemplo de Aendamiento de citas medicas: Proyecto Piedra Azul");
        System.out.println("================================================================================");

        AppointmentDirector director = new AppointmentDirector();
        director.setBuilder(new SelfServiceAppointmentBuilder());

        System.out.println("[1]. Creando una cita medica a traves del Builder para Self Service");
        selfServiceAppointment = director.buildSelfServiceAppointment(
            "123456789", 
            "Juan Rodriguez", 
            "3145456678",
            java.sql.Date.valueOf("2023-11-01"),
            java.sql.Time.valueOf("08:00:00")
        );

        System.out.println("Cita medica creada a traves del Builder para Self Service:");
        System.out.println(selfServiceAppointment);


        System.out.println("\n[2]. Creando una cita medica a traves del Builder para Manual");
        director.setBuilder(new ManualAppointmentBuilder());
        manualAppointment = director.buildManualAppointment( 
            "123456789", 
            "Juan Rodriguez", 
            "3145456678", 
            1000L, 
            "Dr. Perez", 
            java.sql.Date.valueOf("2023-10-10"), 
            java.sql.Time.valueOf("10:00:00"), 
            30, 
            "Control medico", 
            "Agendada" 
        );
        System.out.println("Cita medica creada a traves del Builder para Manual:");
        System.out.println(manualAppointment);

        System.out.println("\n[3]. Creando una cita medica a traves del Builder para Reprogramada");
        RescheduledAppointmentBuilder rescheduleBuilder = new RescheduledAppointmentBuilder(manualAppointment);
        director.setBuilder(rescheduleBuilder);
        rescheduledAppointment = director.buildRescheduledAppointment(
            java.sql.Date.valueOf("2023-10-15"), 
            java.sql.Time.valueOf("11:30:00")
        );
        
        System.out.println("Cita medica creada a traves del Builder para Reprogramada:");
        System.out.println(rescheduledAppointment);
    }
}