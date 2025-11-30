//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
                StudentManagementSystem sms = new StudentManagementSystem();

                while (true) {
                    System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
                    System.out.println("1. Add Student");
                    System.out.println("2. Remove Student");
                    System.out.println("3. Edit Student");
                    System.out.println("4. Search Student");
                    System.out.println("5. Display All Students");
                    System.out.println("6. Exit");
                    System.out.print("Choose an option: ");

                    int choice = sc.nextInt();
                    sc.nextLine(); // consume newline

                    switch (choice) {

                        case 1:
                            System.out.print("Enter Student Name: ");
                            String name = sc.nextLine().trim();

                            // validation
                            while (name.isEmpty()) {
                                System.out.print("Name cannot be empty, re-enter: ");
                                name = sc.nextLine();
                            }

                            System.out.print("Enter Roll Number: ");
                            int roll = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Enter Grade: ");
                            String grade = sc.nextLine().trim();

                            sms.addStudent(new Student(name, roll, grade));
                            System.out.println("Student Added Successfully!");
                            break;

                        case 2:
                            System.out.print("Enter Roll Number to Remove: ");
                            int removeRoll = sc.nextInt();

                            if (sms.removeStudent(removeRoll))
                                System.out.println("Student Removed Successfully!");
                            else
                                System.out.println("Student not found!");
                            break;

                        case 3:
                            System.out.print("Enter Roll Number to Edit: ");
                            int editRoll = sc.nextInt();
                            sc.nextLine();

                            Student s = sms.searchStudent(editRoll);

                            if (s != null) {
                                System.out.print("Enter New Name: ");
                                String newName = sc.nextLine();
                                System.out.print("Enter New Grade: ");
                                String newGrade = sc.nextLine();

                                s.setName(newName);
                                s.setGrade(newGrade);
                                System.out.println("Student Updated Successfully!");
                            } else {
                                System.out.println("Student not found!");
                            }
                            break;

                        case 4:
                            System.out.print("Enter Roll Number to Search: ");
                            int searchRoll = sc.nextInt();

                            Student found = sms.searchStudent(searchRoll);

                            if (found != null)
                                System.out.println(found);
                            else
                                System.out.println("Student not found!");
                            break;

                        case 5:
                            sms.displayStudents();
                            break;

                        case 6:
                            System.out.println("Exiting... Goodbye!");
                            System.exit(0);

                        default:
                            System.out.println("Invalid choice! Try again.");
                    }
                }
            }
        }

