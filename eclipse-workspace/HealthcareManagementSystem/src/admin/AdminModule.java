package admin;

import model.Doctor;
import java.util.ArrayList;
import java.util.Scanner;


public class AdminModule {
	private ArrayList<Doctor>doctors=new ArrayList<>();
	public void addDoctor() {
		Scanner sc=new Scanner(System.in);
        System.out.print("Enter doctor's name: ");
        String name = sc.nextLine();
        System.out.print("Enter specialization: ");
        String specialization = sc.nextLine();
        doctors.add(new Doctor(name, specialization));
        System.out.println("Doctor added successfully.");
    }

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public void viewDoctors() {
        System.out.println("\n--- Doctor List ---");
        for (Doctor doc : doctors) {
            System.out.println("Dr. " + doc.getName() + " - " + doc.getSpecialization());
        }
    }
}

	