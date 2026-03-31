/**
 * Doctor class represents a healthcare professional in the system
 */
public class Doctor {
    private int doctorId;
    private String name;
    private String specialization;
    private String phoneNumber;
    private String email;
    private double consultationFee;

    /**
     * Constructor for Doctor
     */
    public Doctor(int doctorId, String name, String specialization, 
                  String phoneNumber, String email, double consultationFee) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.consultationFee = consultationFee;
    }

    // Getters
    public int getDoctorId() {
        return doctorId;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    // Setters
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setConsultationFee(double consultationFee) {
        this.consultationFee = consultationFee;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "ID=" + doctorId +
                ", Name='" + name + '\'' +
                ", Specialization='" + specialization + '\'' +
                ", Phone='" + phoneNumber + '\'' +
                ", Email='" + email + '\'' +
                ", Fee=$" + consultationFee +
                '}';
    }
}
