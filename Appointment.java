import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Appointment class represents a doctor-patient appointment
 */
public class Appointment {
    private int appointmentId;
    private int patientId;
    private int doctorId;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private String reason;
    private String status; // SCHEDULED, COMPLETED, CANCELLED
    private String notes;

    /**
     * Constructor for Appointment
     */
    public Appointment(int appointmentId, int patientId, int doctorId, 
                      LocalDate appointmentDate, LocalTime appointmentTime, 
                      String reason, String status, String notes) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.reason = reason;
        this.status = status;
        this.notes = notes;
    }

    // Getters
    public int getAppointmentId() {
        return appointmentId;
    }

    public int getPatientId() {
        return patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }

    public String getReason() {
        return reason;
    }

    public String getStatus() {
        return status;
    }

    public String getNotes() {
        return notes;
    }

    // Setters
    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public void setAppointmentTime(LocalTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "ID=" + appointmentId +
                ", PatientID=" + patientId +
                ", DoctorID=" + doctorId +
                ", Date=" + appointmentDate +
                ", Time=" + appointmentTime +
                ", Reason='" + reason + '\'' +
                ", Status='" + status + '\'' +
                ", Notes='" + notes + '\'' +
                '}';
    }
}
