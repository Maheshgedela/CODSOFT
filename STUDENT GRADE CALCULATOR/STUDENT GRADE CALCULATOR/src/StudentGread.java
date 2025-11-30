
import java.util.*;
public class StudentGread {



        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.println("===== STUDENT GRADE CALCULATOR =====");

            // Step 1: Ask total number of subjects
            System.out.print("Enter number of subjects: ");
            int subjects = sc.nextInt();

            int totalMarks = 0;

            // Step 2: Get marks for each subject
            for (int i = 1; i <= subjects; i++) {
                System.out.print("Enter marks for Subject " + i + ": ");
                int marks = sc.nextInt();

                // validation
                while (marks < 0 || marks > 100) {
                    System.out.print("Invalid marks! Enter 0 to 100 only: ");
                    marks = sc.nextInt();
                }

                totalMarks += marks;
            }

            // Step 3: Calculate average / percentage
            double percentage = (double) totalMarks / subjects;

            // Step 4: Assign grade
            char grade;

            if (percentage >= 90) {
                grade = 'A';
            } else if (percentage >= 80) {
                grade = 'B';
            } else if (percentage >= 70) {
                grade = 'C';
            } else if (percentage >= 60) {
                grade = 'D';
            } else {
                grade = 'F';
            }

            // Step 5: Display the results
            System.out.println("\n===== RESULT =====");
            System.out.println("Total Marks: " + totalMarks);
            System.out.println("Percentage : " + percentage + "%");
            System.out.println("Grade      : " + grade);

            sc.close();
        }
    }


