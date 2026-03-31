import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

/**
 * AppointmentManager class handles all appointment-related operations
 */
public class AppointmentManager {
    private List<Appointment> appointments;
    private int appointmentCounter;

    /**
     * Constructor for AppointmentManager
     */
    public AppointmentManager() {
        this.appointments = new ArrayList<>();
        this.appointmentCounter = 1000;
    }

    /**
     * Book a new appointment
     */
    public boolean bookAppointment(int patientId, int doctorId, 
                                   LocalDate date, LocalTime time, String reason) {
        // Validate date is not in the past
        if (date.isBefore(LocalDate.now())) {
            System.out.println("Error: Cannot book appointment in the past.");
            return false;
        }

        // Check if slot is available
        if (!isSlotAvailable(doctorId, date, time)) {
            System.out.println("Error: Slot is not available for the selected date and time.");
            return false;
        }

        int newAppointmentId = ++appointmentCounter;
        Appointment appointment = new Appointment(
            newAppointmentId, patientId, doctorId, date, time, reason, "SCHEDULED", ""
        );

        appointments.add(appointment);
        System.out.println("Appointment booked successfully! ID: " + newAppointmentId);
        return true;
    }

    /**
     * Check if a slot is available for a doctor at a specific date and time
     */
    private boolean isSlotAvailable(int doctorId, LocalDate date, LocalTime time) {
        return appointments.stream()
            .noneMatch(a -> a.getDoctorId() == doctorId && 
                           a.getAppointmentDate().equals(date) && 
                           a.getAppointmentTime().equals(time) &&
                           !a.getStatus().equals("CANCELLED"));
    }

    /**
     * Cancel an appointment
     */
    public boolean cancelAppointment(int appointmentId) {
        Appointment appointment = findAppointmentById(appointmentId);
        if (appointment != null && !appointment.getStatus().equals("CANCELLED")) {
            appointment.setStatus("CANCELLED");
            System.out.println("Appointment cancelled successfully!");
            return true;
        }
        System.out.println("Error: Appointment not found or already cancelled.");
        return false;
    }

    /**
     * Reschedule an existing appointment
     */
    public boolean rescheduleAppointment(int appointmentId, LocalDate newDate, LocalTime newTime) {
        Appointment appointment = findAppointmentById(appointmentId);
        
        if (appointment == null || appointment.getStatus().equals("CANCELLED")) {
            System.out.println("Error: Appointment not found or already cancelled.");
            return false;
        }

        if (newDate.isBefore(LocalDate.now())) {
            System.out.println("Error: Cannot reschedule to a past date.");
            return false;
        }

        if (!isSlotAvailable(appointment.getDoctorId(), newDate, newTime)) {
            System.out.println("Error: New slot is not available.");
            return false;
        }

        appointment.setAppointmentDate(newDate);
        appointment.setAppointmentTime(newTime);
        System.out.println("Appointment rescheduled successfully!");
        return true;
    }

    /**
     * View all appointments for a patient
     */
    public List<Appointment> getPatientAppointments(int patientId) {
        List<Appointment> patientAppointments = new ArrayList<>();
        for (Appointment a : appointments) {
            if (a.getPatientId() == patientId && !a.getStatus().equals("CANCELLED")) {
                patientAppointments.add(a);
            }
        }
        return patientAppointments;
    }

    /**
     * View all appointments for a doctor
     */
    public List<Appointment> getDoctorAppointments(int doctorId) {
        List<Appointment> doctorAppointments = new ArrayList<>();
        for (Appointment a : appointments) {
            if (a.getDoctorId() == doctorId && !a.getStatus().equals("CANCELLED")) {
                doctorAppointments.add(a);
            }
        }
        return doctorAppointments;
    }

    /**
     * Find appointment by ID
     */
    public Appointment findAppointmentById(int appointmentId) {
        return appointments.stream()
            .filter(a -> a.getAppointmentId() == appointmentId)
            .findFirst()
            .orElse(null);
    }

    /**
     * View all appointments
     */
    public List<Appointment> getAllAppointments() {
        return new ArrayList<>(appointments);
    }

    /**
     * Get available slots for a doctor on a specific date
     */
    public List<LocalTime> getAvailableSlots(int doctorId, LocalDate date) {
        List<LocalTime> allSlots = generateTimeSlots();
        List<LocalTime> bookedSlots = appointments.stream()
            .filter(a -> a.getDoctorId() == doctorId && 
                        a.getAppointmentDate().equals(date) &&
                        !a.getStatus().equals("CANCELLED"))
            .map(Appointment::getAppointmentTime)
            .toList();

        allSlots.removeAll(bookedSlots);
        return allSlots;
    }

    /**
     * Generate available time slots (9 AM to 5 PM, 1 hour intervals)
     */
    private List<LocalTime> generateTimeSlots() {
        List<LocalTime> slots = new ArrayList<>();
        for (int hour = 9; hour < 17; hour++) {
            slots.add(LocalTime.of(hour, 0));
        }
        return slots;
    }
}
