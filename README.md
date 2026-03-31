# Doctor Appointment Booking System

A comprehensive Java-based appointment booking system for managing doctor-patient appointments.

## Project Structure

```
DoctorAppointmentSystem/
├── src/
│   ├── Doctor.java                          # Doctor entity class
│   ├── Patient.java                         # Patient entity class
│   ├── Appointment.java                     # Appointment entity class
│   ├── DoctorManagementSystem.java           # Doctor & patient management
│   ├── AppointmentManager.java               # Appointment operations
│   └── DoctorAppointmentBookingSystem.java   # Main application class
└── README.md                                # This file
```

## Files Overview

### 1. **Doctor.java**
Represents a doctor in the system with the following attributes:
- Doctor ID
- Name
- Specialization
- Phone Number
- Email
- Consultation Fee

Methods include getters, setters, and toString() for easy viewing.

### 2. **Patient.java**
Represents a patient in the system with the following attributes:
- Patient ID
- Name
- Age
- Gender
- Phone Number
- Email
- Medical History

Methods include getters, setters, and toString() for easy viewing.

### 3. **Appointment.java**
Represents an appointment between doctor and patient with:
- Appointment ID
- Patient ID
- Doctor ID
- Appointment Date
- Appointment Time
- Reason for visit
- Status (SCHEDULED, COMPLETED, CANCELLED)
- Notes

### 4. **DoctorManagementSystem.java**
Handles all doctor and patient management operations:

**Doctor Operations:**
- Register new doctor
- Search doctor by ID
- Search doctors by specialization
- Update doctor information
- Delete doctor
- View all doctors

**Patient Operations:**
- Register new patient
- Search patient by ID
- Search patients by name
- Update patient information
- Delete patient
- View all patients

### 5. **AppointmentManager.java**
Manages all appointment-related operations:
- Book a new appointment
- Cancel appointment
- Reschedule appointment
- View patient appointments
- View doctor appointments
- Check slot availability
- View available time slots
- Validate date/time constraints

### 6. **DoctorAppointmentBookingSystem.java**
Main application class with interactive menu-driven interface:
- Patient Management Menu
- Doctor Management Menu
- Appointment Management Menu
- User-friendly console UI
- Input validation

## Features

✅ **Patient Management**
- Register new patients
- Update patient information
- Search and view patient details
- Delete patient records

✅ **Doctor Management**
- Register new doctors
- Update doctor information
- Search doctors by specialization
- View doctor details
- Manage doctor records

✅ **Appointment Booking**
- Book appointments with date/time validation
- Prevent double-booking of time slots
- Reschedule appointments
- Cancel appointments
- View available time slots
- Track appointment status

✅ **Data Management**
- Prevent appointments in the past
- Check appointment slot availability
- Filter appointments by patient/doctor
- Display all system appointments

## How to Compile and Run

### Compilation
```bash
cd DoctorAppointmentSystem/src
javac *.java
```

### Execution
```bash
java DoctorAppointmentBookingSystem
```

## Usage Example

### 1. Register a Doctor
- Select option 2 (Doctor Management)
- Select option 1 (Register New Doctor)
- Enter doctor details: name, specialization, phone, email, consultation fee

### 2. Register a Patient
- Select option 1 (Patient Management)
- Select option 1 (Register New Patient)
- Enter patient details: name, age, gender, phone, email, medical history

### 3. Book an Appointment
- Select option 3 (Appointment Management)
- Select option 1 (Book an Appointment)
- Enter patient ID, doctor ID, date (yyyy-MM-dd), time (HH:00), and reason

### 4. Reschedule Appointment
- Select option 3 (Appointment Management)
- Select option 4 (Reschedule Appointment)
- Enter appointment ID and new date/time

### 5. Cancel Appointment
- Select option 3 (Appointment Management)
- Select option 5 (Cancel Appointment)
- Enter appointment ID

## Time Slots
Available appointment slots: 9:00 AM to 4:00 PM (hourly intervals)
- 9:00, 10:00, 11:00, 12:00, 13:00, 14:00, 15:00, 16:00

## Validation Rules

1. **Cannot book appointments in the past**
2. **Cannot double-book a doctor's time slot**
3. **Cannot reschedule to past dates**
4. **Cannot cancel already cancelled appointments**
5. **All IDs must exist in the system**

## Future Enhancements

- Database integration (MySQL/PostgreSQL)
- File persistence (save/load data)
- Payment processing
- Email notifications
- SMS reminders
- Doctor ratings and reviews
- Prescription management
- Medical reports
- Appointment history
- Advanced search filters

## Technologies Used

- Java 8+
- Collections Framework (ArrayList, List)
- LocalDate and LocalTime for date/time handling
- Stream API for filtering operations

## Author

Doctor Appointment Booking System v1.0

## License

MIT License
