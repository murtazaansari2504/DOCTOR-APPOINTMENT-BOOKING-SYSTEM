import java.util.*;

/**
 * DoctorManagementSystem class manages doctors and patients in the system
 */
public class DoctorManagementSystem {
    private List<Doctor> doctors;
    private List<Patient> patients;
    private int doctorCounter;
    private int patientCounter;

    /**
     * Constructor for DoctorManagementSystem
     */
    public DoctorManagementSystem() {
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
        this.doctorCounter = 100;
        this.patientCounter = 1000;
    }

    // ========== DOCTOR MANAGEMENT ==========

    /**
     * Register a new doctor
     */
    public int registerDoctor(String name, String specialization, 
                              String phoneNumber, String email, double consultationFee) {
        int newDoctorId = ++doctorCounter;
        Doctor doctor = new Doctor(newDoctorId, name, specialization, phoneNumber, email, consultationFee);
        doctors.add(doctor);
        System.out.println("Doctor registered successfully! ID: " + newDoctorId);
        return newDoctorId;
    }

    /**
     * Get doctor by ID
     */
    public Doctor getDoctorById(int doctorId) {
        return doctors.stream()
            .filter(d -> d.getDoctorId() == doctorId)
            .findFirst()
            .orElse(null);
    }

    /**
     * Get all doctors
     */
    public List<Doctor> getAllDoctors() {
        return new ArrayList<>(doctors);
    }

    /**
     * Search doctors by specialization
     */
    public List<Doctor> searchDoctorsBySpecialization(String specialization) {
        List<Doctor> result = new ArrayList<>();
        for (Doctor d : doctors) {
            if (d.getSpecialization().toLowerCase().contains(specialization.toLowerCase())) {
                result.add(d);
            }
        }
        return result;
    }

    /**
     * Update doctor information
     */
    public boolean updateDoctor(int doctorId, String phoneNumber, String email, double consultationFee) {
        Doctor doctor = getDoctorById(doctorId);
        if (doctor != null) {
            doctor.setPhoneNumber(phoneNumber);
            doctor.setEmail(email);
            doctor.setConsultationFee(consultationFee);
            System.out.println("Doctor information updated successfully!");
            return true;
        }
        System.out.println("Error: Doctor not found.");
        return false;
    }

    /**
     * Remove/Delete doctor
     */
    public boolean removeDoctor(int doctorId) {
        Doctor doctor = getDoctorById(doctorId);
        if (doctor != null) {
            doctors.remove(doctor);
            System.out.println("Doctor removed successfully!");
            return true;
        }
        System.out.println("Error: Doctor not found.");
        return false;
    }

    // ========== PATIENT MANAGEMENT ==========

    /**
     * Register a new patient
     */
    public int registerPatient(String name, int age, String gender, 
                               String phoneNumber, String email, String medicalHistory) {
        int newPatientId = ++patientCounter;
        Patient patient = new Patient(newPatientId, name, age, gender, phoneNumber, email, medicalHistory);
        patients.add(patient);
        System.out.println("Patient registered successfully! ID: " + newPatientId);
        return newPatientId;
    }

    /**
     * Get patient by ID
     */
    public Patient getPatientById(int patientId) {
        return patients.stream()
            .filter(p -> p.getPatientId() == patientId)
            .findFirst()
            .orElse(null);
    }

    /**
     * Get all patients
     */
    public List<Patient> getAllPatients() {
        return new ArrayList<>(patients);
    }

    /**
     * Search patients by name
     */
    public List<Patient> searchPatientsByName(String name) {
        List<Patient> result = new ArrayList<>();
        for (Patient p : patients) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(p);
            }
        }
        return result;
    }

    /**
     * Update patient information
     */
    public boolean updatePatient(int patientId, String phoneNumber, String email, String medicalHistory) {
        Patient patient = getPatientById(patientId);
        if (patient != null) {
            patient.setPhoneNumber(phoneNumber);
            patient.setEmail(email);
            patient.setMedicalHistory(medicalHistory);
            System.out.println("Patient information updated successfully!");
            return true;
        }
        System.out.println("Error: Patient not found.");
        return false;
    }

    /**
     * Remove/Delete patient
     */
    public boolean removePatient(int patientId) {
        Patient patient = getPatientById(patientId);
        if (patient != null) {
            patients.remove(patient);
            System.out.println("Patient removed successfully!");
            return true;
        }
        System.out.println("Error: Patient not found.");
        return false;
    }
}
