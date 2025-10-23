package client;
import model.Appointment;
import model.Doctor;
import model.User;

import java.util.*;


public class ClientModule {
	private Map<String,User>users=new HashMap<>();
	private List<Appointment>appointments=new ArrayList<>();
	public void register() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter full name: ");
        String fullName = sc.nextLine();
        System.out.print("Choose username: ");
        String username = sc.nextLine();
        System.out.print("Choose password: ");
        String password = sc.nextLine();

        if (users.containsKey(username)) {
            System.out.println("Username already exists.");
            return;
        }

        users.put(username, new User(username, password, fullName));
        System.out.println("Registration successful.");
    }

    public User login() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();

        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Login successful. Welcome, " + user.getFullName());
            return user;
        } else {
            System.out.println("Invalid credentials.");
            return null;
        }
    }

    public void bookAppointment(User user, List<Doctor> doctorList) {
        if (doctorList.isEmpty()) {
            System.out.println("No doctors available.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("\nAvailable Doctors:");
        for (int i = 0; i < doctorList.size(); i++) {
            System.out.println((i + 1) + ". Dr. " + doctorList.get(i).getName() + " - " + doctorList.get(i).getSpecialization());
        }

        System.out.print("Choose doctor number: ");
        int choice = sc.nextInt(); sc.nextLine();

        if (choice < 1 || choice > doctorList.size()) {
            System.out.println("Invalid choice.");
            return;
        }

        Doctor selectedDoctor = doctorList.get(choice - 1);
        System.out.print("Enter appointment date (YYYY-MM-DD): ");
        String date = sc.nextLine();

        appointments.add(new Appointment(user.getUsername(), selectedDoctor.getName(), date));
        System.out.println("Appointment booked with Dr. " + selectedDoctor.getName() + " on " + date);
    }

    public void viewAppointments(String username) {
        System.out.println("\n--- Your Appointments ---");
        for (Appointment appt : appointments) {
            if (appt.getPatientUsername().equals(username)) {
                System.out.println("Dr. " + appt.getDoctorName() + " on " + appt.getDate());
            }
        }
    }
}
