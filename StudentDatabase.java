import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDatabase {
    private List<Student> students = new ArrayList<>();

    // Method to add a student to the database
    public void addStudent(Student student) {
        students.add(student);
    }

    // Method to delete a student from the database
    public void deleteStudent(String studentID) {
        students.removeIf(student -> student.getStudentID().equals(studentID));
    }

    // Method to update student information
    public void updateStudent(String studentID, String name, String gender, int age) {
        for (Student student : students) {
            if (student.getStudentID().equals(studentID)) {
                student.setName(name);
                student.setGender(gender);
                student.setAge(age);
                break;
            }
        }
    }

    // Method to search for a student by ID
    public Student findStudent(String studentID) {
        for (Student student : students) {
            if (student.getStudentID().equals(studentID)) {
                return student;
            }
        }
        return null;
    }

    // Method to display information of all students
    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // Method to save student information to a file
    public void saveToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Student student : students) {
                writer.println(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to load student information from a file
    public void loadFromFile(String filename) {
        students.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    Student student = new Student(parts[0], parts[1], parts[3], Integer.parseInt(parts[2]));
                    students.add(student);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve all students from the database
    public List<Student> getAllStudents() {
        return students;
    }
}

