import java.util.Comparator;
import java.util.Scanner;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentDatabase database = new StudentDatabase();

        System.out.println("Welcome to Student Management System");

        int choice;
        do {
            System.out.println("********************************************");
            System.out.println("[0] Save and Exit");
            System.out.println("[1] Show all students");
            System.out.println("[2] Add a student");
            System.out.println("[3] Delete a student");
            System.out.println("[4] Update student information");
            System.out.println("[5] Find a student");
            System.out.println("[6] Rank students by ID");
            System.out.println("[7] Find students with max/min ID");
            System.out.println("********************************************");
            System.out.print("Please enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 0:
                    System.out.println("Student information saved. Exiting program.");
                    break;
                case 1:
                    database.displayAllStudents();
                    break;
                case 2:
                    addStudent(scanner, database);
                    break;
                case 3:
                    deleteStudent(scanner, database);
                    break;
                case 4:
                    updateStudent(scanner, database);
                    break;
                case 5:
                    findStudent(scanner, database);
                    break;
                case 6:
                    rankStudents(scanner, database);
                    break;
                case 7:
                    findMinMaxStudent(scanner, database);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    // Method to add a student
    private static void addStudent(Scanner scanner, StudentDatabase database) {
        System.out.print("Enter student ID: ");
        String studentID = scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        database.addStudent(new Student(studentID, name, gender, age));
        System.out.println("Student added successfully.");
    }

    // Method to delete a student
    private static void deleteStudent(Scanner scanner, StudentDatabase database) {
        System.out.print("Enter student ID to delete: ");
        String studentID = scanner.nextLine();
        database.deleteStudent(studentID);
        System.out.println("Student deleted successfully.");
    }

    // Method to update student information
    private static void updateStudent(Scanner scanner, StudentDatabase database) {
        System.out.print("Enter student ID to update: ");
        String studentID = scanner.nextLine();
        System.out.print("Enter new name (press Enter to skip): ");
        String name = scanner.nextLine();
        System.out.print("Enter new gender (press Enter to skip): ");
        String gender = scanner.nextLine();
        System.out.print("Enter new age (press Enter to skip): ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        database.updateStudent(studentID, name, gender, age);
        System.out.println("Student information updated successfully.");
    }

    // Method to find a student
    private static void findStudent(Scanner scanner, StudentDatabase database) {
        System.out.print("Enter student ID to find: ");
        String studentID = scanner.nextLine();
        Student student = database.findStudent(studentID);
        if (student != null) {
            System.out.println("Student found: " + student);
        } else {
            System.out.println("Student not found.");
        }
    }

    // Method to rank students
    // Method to rank students
    private static void rankStudents(Scanner scanner, StudentDatabase database) {
        System.out.print("Enter 1 to rank in descending order, else for ascending: ");
        int order = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        List<Student> students = database.getAllStudents();
        if (order == 1) {
            // Sort students in descending order by student ID
            students.sort(Comparator.comparing(Student::getStudentID).reversed());
        } else {
            // Sort students in ascending order by student ID
            students.sort(Comparator.comparing(Student::getStudentID));
        }
        // Display ranked students
        System.out.println("Ranked students:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // Method to find students with max/min ID
    private static void findMinMaxStudent(Scanner scanner, StudentDatabase database) {
        System.out.print("Enter 1 to find student with max ID, else for min ID: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        List<Student> students = database.getAllStudents();
        if (!students.isEmpty()) {
            // Find student with max/min ID
            Student result = students.get(0);
            for (Student student : students) {
                if (choice == 1) {
                    if (student.getStudentID().compareTo(result.getStudentID()) > 0) {
                        result = student;
                    }
                } else {
                    if (student.getStudentID().compareTo(result.getStudentID()) < 0) {
                        result = student;
                    }
                }
            }
            System.out.println("Student with " + (choice == 1 ? "max" : "min") + " ID:");
            System.out.println(result);
        } else {
            System.out.println("No students in the database.");
        }
    }

}
