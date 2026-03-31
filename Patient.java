/**
 * Patient class represents a patient in the system
 */
public class Patient {
    private int patientId;
    private String name;
    private int age;
    private String gender;
    private String phoneNumber;
    private String email;
    private String medicalHistory;

    /**
     * Constructor for Patient
     */
    public Patient(int patientId, String name, int age, String gender, 
                   String phoneNumber, String email, String medicalHistory) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.medicalHistory = medicalHistory;
    }

    // Getters
    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    // Setters
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "ID=" + patientId +
                ", Name='" + name + '\'' +
                ", Age=" + age +
                ", Gender='" + gender + '\'' +
                ", Phone='" + phoneNumber + '\'' +
                ", Email='" + email + '\'' +
                ", Medical History='" + medicalHistory + '\'' +
                '}';
    }
}
