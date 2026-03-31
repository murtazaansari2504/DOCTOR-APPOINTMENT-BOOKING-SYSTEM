import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Main DoctorAppointmentBookingSystem class with interactive menu-driven interface
 */
public class DoctorAppointmentBookingSystem {
    private DoctorManagementSystem managementSystem;
    private AppointmentManager appointmentManager;
    private Scanner scanner;

    /**
     * Constructor
     */
    public DoctorAppointmentBookingSystem() {
        this.managementSystem = new DoctorManagementSystem();
        this.appointmentManager = new AppointmentManager();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Main menu of the application
     */
    public void start() {
        boolean running = true;
        while (running) {
            displayMainMenu();
            int choice = getInput();
            
            switch (choice) {
                case 1:
                    patientMenu();
                    break;
                case 2:
                    doctorMenu();
                    break;
                case 3:
                    appointmentMenu();
                    break;
                case 4:
                    viewAllAppointments();
                    break;
                case 5:
                    System.out.println("\n✓ Thank you for using Doctor Appointment Booking System. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        scanner.close();
    }

    /**
     * Display main menu
     */
    private void displayMainMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("       DOCTOR APPOINTMENT BOOKING SYSTEM");
        System.out.println("=".repeat(50));
        System.out.println("1. Patient Management");
        System.out.println("2. Doctor Management");
        System.out.println("3. Appointment Management");
        System.out.println("4. View All Appointments");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    // ========== PATIENT MENU ==========
    private void patientMenu() {
        boolean inPatientMenu = true;
        while (inPatientMenu) {
            System.out.println("\n" + "-".repeat(50));
            System.out.println("PATIENT MANAGEMENT");
            System.out.println("-".repeat(50));
            System.out.println("1. Register New Patient");
            System.out.println("2. View Patient Details");
            System.out.println("3. Update Patient Information");
            System.out.println("4. Search Patient by Name");
            System.out.println("5. View All Patients");
            System.out.println("6. Delete Patient");
            System.out.println("7. Back to Main Menu");
            System.out.print("Enter your choice: ");
            
            int choice = getInput();
            switch (choice) {
                case 1:
                    registerPatient();
                    break;
                case 2:
                    viewPatient();
                    break;
                case 3:
                    updatePatient();
                    break;
                case 4:
                    searchPatient();
                    break;
                case 5:
                    displayAllPatients();
                    break;
                case 6:
                    deletePatient();
                    break;
                case 7:
                    inPatientMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private void registerPatient() {
        System.out.print("\nEnter patient name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = getInput();
        System.out.print("Enter gender (M/F/Other): ");
        String gender = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter medical history: ");
        String medicalHistory = scanner.nextLine();
        
        managementSystem.registerPatient(name, age, gender, phone, email, medicalHistory);
    }

    private void viewPatient() {
        System.out.print("\nEnter patient ID: ");
        int patientId = getInput();
        Patient patient = managementSystem.getPatientById(patientId);
        
        if (patient != null) {
            System.out.println("\n" + patient);
        } else {
            System.out.println("Patient not found!");
        }
    }

    private void updatePatient() {
        System.out.print("\nEnter patient ID: ");
        int patientId = getInput();
        System.out.print("Enter new phone number: ");
        String phone = scanner.nextLine();
        System.out.print("Enter new email: ");
        String email = scanner.nextLine();
        System.out.print("Enter updated medical history: ");
        String medicalHistory = scanner.nextLine();
        
        managementSystem.updatePatient(patientId, phone, email, medicalHistory);
    }

    private void searchPatient() {
        System.out.print("\nEnter patient name to search: ");
        String name = scanner.nextLine();
        List<Patient> results = managementSystem.searchPatientsByName(name);
        
        if (results.isEmpty()) {
            System.out.println("No patients found!");
        } else {
            System.out.println("\nSearch Results:");
            results.forEach(System.out::println);
        }
    }

    private void displayAllPatients() {
        List<Patient> patients = managementSystem.getAllPatients();
        if (patients.isEmpty()) {
            System.out.println("\nNo patients registered yet!");
        } else {
            System.out.println("\n--- All Patients ---");
            patients.forEach(System.out::println);
        }
    }

    private void deletePatient() {
        System.out.print("\nEnter patient ID to delete: ");
        int patientId = getInput();
        managementSystem.removePatient(patientId);
    }

    // ========== DOCTOR MENU ==========
    private void doctorMenu() {
        boolean inDoctorMenu = true;
        while (inDoctorMenu) {
            System.out.println("\n" + "-".repeat(50));
            System.out.println("DOCTOR MANAGEMENT");
            System.out.println("-".repeat(50));
            System.out.println("1. Register New Doctor");
            System.out.println("2. View Doctor Details");
            System.out.println("3. Update Doctor Information");
            System.out.println("4. Search Doctors by Specialization");
            System.out.println("5. View All Doctors");
            System.out.println("6. Delete Doctor");
            System.out.println("7. Back to Main Menu");
            System.out.print("Enter your choice: ");
            
            int choice = getInput();
            switch (choice) {
                case 1:
                    registerDoctor();
                    break;
                case 2:
                    viewDoctor();
                    break;
                case 3:
                    updateDoctor();
                    break;
                case 4:
                    searchDoctor();
                    break;
                case 5:
                    displayAllDoctors();
                    break;
                case 6:
                    deleteDoctor();
                    break;
                case 7:
                    inDoctorMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private void registerDoctor() {
        System.out.print("\nEnter doctor name: ");
        String name = scanner.nextLine();
        System.out.print("Enter specialization: ");
        String specialization = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter consultation fee: ");
        double fee = getDoubleInput();
        
        managementSystem.registerDoctor(name, specialization, phone, email, fee);
    }

    private void viewDoctor() {
        System.out.print("\nEnter doctor ID: ");
        int doctorId = getInput();
        Doctor doctor = managementSystem.getDoctorById(doctorId);
        
        if (doctor != null) {
            System.out.println("\n" + doctor);
        } else {
            System.out.println("Doctor not found!");
        }
    }

    private void updateDoctor() {
        System.out.print("\nEnter doctor ID: ");
        int doctorId = getInput();
        System.out.print("Enter new phone number: ");
        String phone = scanner.nextLine();
        System.out.print("Enter new email: ");
        String email = scanner.nextLine();
        System.out.print("Enter new consultation fee: ");
        double fee = getDoubleInput();
        
        managementSystem.updateDoctor(doctorId, phone, email, fee);
    }

    private void searchDoctor() {
        System.out.print("\nEnter specialization to search: ");
        String specialization = scanner.nextLine();
        List<Doctor> results = managementSystem.searchDoctorsBySpecialization(specialization);
        
        if (results.isEmpty()) {
            System.out.println("No doctors found with that specialization!");
        } else {
            System.out.println("\nSearch Results:");
            results.forEach(System.out::println);
        }
    }

    private void displayAllDoctors() {
        List<Doctor> doctors = managementSystem.getAllDoctors();
        if (doctors.isEmpty()) {
            System.out.println("\nNo doctors registered yet!");
        } else {
            System.out.println("\n--- All Doctors ---");
            doctors.forEach(System.out::println);
        }
    }

    private void deleteDoctor() {
        System.out.print("\nEnter doctor ID to delete: ");
        int doctorId = getInput();
        managementSystem.removeDoctor(doctorId);
    }

    // ========== APPOINTMENT MENU ==========
    private void appointmentMenu() {
        boolean inAppointmentMenu = true;
        while (inAppointmentMenu) {
            System.out.println("\n" + "-".repeat(50));
            System.out.println("APPOINTMENT MANAGEMENT");
            System.out.println("-".repeat(50));
            System.out.println("1. Book an Appointment");
            System.out.println("2. View Patient Appointments");
            System.out.println("3. View Doctor Appointments");
            System.out.println("4. Reschedule Appointment");
            System.out.println("5. Cancel Appointment");
            System.out.println("6. View Available Slots");
            System.out.println("7. Back to Main Menu");
            System.out.print("Enter your choice: ");
            
            int choice = getInput();
            switch (choice) {
                case 1:
                    bookAppointment();
                    break;
                case 2:
                    viewPatientAppointments();
                    break;
                case 3:
                    viewDoctorAppointments();
                    break;
                case 4:
                    rescheduleAppointment();
                    break;
                case 5:
                    cancelAppointment();
                    break;
                case 6:
                    viewAvailableSlots();
                    break;
                case 7:
                    inAppointmentMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private void bookAppointment() {
        System.out.print("\nEnter patient ID: ");
        int patientId = getInput();
        System.out.print("Enter doctor ID: ");
        int doctorId = getInput();
        System.out.print("Enter appointment date (yyyy-MM-dd): ");
        LocalDate date = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.print("Enter appointment time (HH:00): ");
        LocalTime time = LocalTime.parse(scanner.nextLine());
        System.out.print("Enter reason for appointment: ");
        String reason = scanner.nextLine();
        
        appointmentManager.bookAppointment(patientId, doctorId, date, time, reason);
    }

    private void viewPatientAppointments() {
        System.out.print("\nEnter patient ID: ");
        int patientId = getInput();
        List<Appointment> appointments = appointmentManager.getPatientAppointments(patientId);
        
        if (appointments.isEmpty()) {
            System.out.println("No appointments found for this patient!");
        } else {
            System.out.println("\n--- Patient Appointments ---");
            appointments.forEach(System.out::println);
        }
    }

    private void viewDoctorAppointments() {
        System.out.print("\nEnter doctor ID: ");
        int doctorId = getInput();
        List<Appointment> appointments = appointmentManager.getDoctorAppointments(doctorId);
        
        if (appointments.isEmpty()) {
            System.out.println("No appointments found for this doctor!");
        } else {
            System.out.println("\n--- Doctor Appointments ---");
            appointments.forEach(System.out::println);
        }
    }

    private void rescheduleAppointment() {
        System.out.print("\nEnter appointment ID: ");
        int appointmentId = getInput();
        System.out.print("Enter new date (yyyy-MM-dd): ");
        LocalDate newDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.print("Enter new time (HH:00): ");
        LocalTime newTime = LocalTime.parse(scanner.nextLine());
        
        appointmentManager.rescheduleAppointment(appointmentId, newDate, newTime);
    }

    private void cancelAppointment() {
        System.out.print("\nEnter appointment ID: ");
        int appointmentId = getInput();
        appointmentManager.cancelAppointment(appointmentId);
    }

    private void viewAvailableSlots() {
        System.out.print("\nEnter doctor ID: ");
        int doctorId = getInput();
        System.out.print("Enter date (yyyy-MM-dd): ");
        LocalDate date = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ISO_LOCAL_DATE);
        
        List<LocalTime> slots = appointmentManager.getAvailableSlots(doctorId, date);
        
        if (slots.isEmpty()) {
            System.out.println("No available slots for this date!");
        } else {
            System.out.println("\nAvailable slots:");
            slots.forEach(time -> System.out.println("  - " + time));
        }
    }

    private void viewAllAppointments() {
        List<Appointment> appointments = appointmentManager.getAllAppointments();
        if (appointments.isEmpty()) {
            System.out.println("\nNo appointments in the system!");
        } else {
            System.out.println("\n--- All Appointments ---");
            appointments.forEach(System.out::println);
        }
    }

    // ========== UTILITY METHODS ==========
    private int getInput() {
        try {
            int input = Integer.parseInt(scanner.nextLine());
            return input;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a number.");
            return -1;
        }
    }

    private double getDoubleInput() {
        try {
            return Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid number.");
            return -1;
        }
    }

    /**
     * Main method - Entry point of the application
     */
    public static void main(String[] args) {
        DoctorAppointmentBookingSystem system = new DoctorAppointmentBookingSystem();
        system.start();
    }
}
