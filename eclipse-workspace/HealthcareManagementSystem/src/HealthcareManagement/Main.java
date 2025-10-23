package HealthcareManagement;


import admin.AdminModule;
import client.ClientModule;
import model.User;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdminModule admin = new AdminModule();
        ClientModule client = new ClientModule();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== E-Healthcare Management System ===");
            System.out.println("1. Admin Login");
            System.out.println("2. Patient Registration");
            System.out.println("3. Patient Login");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter admin password: ");
                    String adminPass = sc.nextLine();
                    if (adminPass.equals("admin123")) {
                        boolean adminLoop = true;
                        while (adminLoop) {
                            System.out.println("\n--- Admin Module ---");
                            System.out.println("1. Add Doctor");
                            System.out.println("2. View Doctors");
                            System.out.println("0. Logout");
                            System.out.print("Choice: ");
                            int adminChoice = sc.nextInt(); sc.nextLine();
                            switch (adminChoice) {
                                case 1: admin.addDoctor(); break;
                                case 2: admin.viewDoctors(); break;
                                case 0: adminLoop = false; break;
                            }
                        }
                    } else {
                        System.out.println("Incorrect password.");
                    }
                    break;
                case 2:
                    client.register();
                    break;
                case 3:
                    User user = client.login();
                    if (user != null) {
                        boolean clientLoop = true;
                        while (clientLoop) {
                            System.out.println("\n--- Patient Dashboard ---");
                            System.out.println("1. Book Appointment");
                            System.out.println("2. View My Appointments");
                            System.out.println("0. Logout");
                            System.out.print("Choice: ");
                            int userChoice = sc.nextInt(); sc.nextLine();
                            switch (userChoice) {
                                case 1: client.bookAppointment(user, admin.getDoctors()); break;
                                case 2: client.viewAppointments(user.getUsername()); break;
                                case 0: clientLoop = false; break;
                            }
                        }
                    }
                    break;
                case 0:
                    System.out.println("Exiting system...");
                    return;
            }
        }
    }
}


	
