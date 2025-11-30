import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class StudentManagementSystem {
    private ArrayList<Student> students = new ArrayList<>();
    private final String FILE_NAME = "students.dat";

    public StudentManagementSystem() {
        loadFromFile();
    }

    // Add Student
    public void addStudent(Student student) {
        students.add(student);
        saveToFile();
    }

    // Remove Student by Roll Number
    public boolean removeStudent(int roll) {
        for (Student s : students) {
            if (s.getRollNumber() == roll) {
                students.remove(s);
                saveToFile();
                return true;
            }
        }
        return false;
    }

    // Search Student by Roll Number
    public Student searchStudent(int roll) {
        for (Student s : students) {
            if (s.getRollNumber() == roll) return s;
        }
        return null;
    }

    // Display all students
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found!");
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    // Save to File
    private void saveToFile() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
            out.writeObject(students);
            out.close();
        } catch (Exception e) {
            System.out.println("Error saving students!");
        }
    }

    // Load from File
    private void loadFromFile() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME));
            students = (ArrayList<Student>) in.readObject();
            in.close();
        } catch (Exception e) {
            students = new ArrayList<>(); // file not found or empty
        }
    }
}


