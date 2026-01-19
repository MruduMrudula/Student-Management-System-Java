import java.util.ArrayList;
import java.util.Scanner;
public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    System.out.println("Delete Student - Coming Soon");
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
        sc.close();
    }

    // Add Student
    public static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();   // clear buffer

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        students.add(new Student(id, name, age, course));
        System.out.println("Student added successfully!");
    }

    // View Students
    public static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("\n--- Student List ---");
            for (Student s : students) {
                System.out.println(
                        "ID: " + s.id +
                        ", Name: " + s.name +
                        ", Age: " + s.age +
                        ", Course: " + s.course
                );
            }
        }
    }

            // Update Student
     public static void updateStudent() {
    if (students.isEmpty()) {
        System.out.println("No students to update.");
        return;
    }

    System.out.print("Enter Student ID to update: ");
    int id = sc.nextInt();
    sc.nextLine(); // clear buffer

    boolean found = false;

    for (Student s : students) {
        if (s.id == id) {
            found = true;

            System.out.println("Current Details:");
            System.out.println("ID: " + s.id);
            System.out.println("Name: " + s.name);
            System.out.println("Age: " + s.age);
            System.out.println("Course: " + s.course);

            System.out.println("\nEnter new details:");

            System.out.print("New Name: ");
            s.name = sc.nextLine();

            System.out.print("New Age: ");
            s.age = sc.nextInt();
            sc.nextLine();

            System.out.print("New Course: ");
            s.course = sc.nextLine();

            System.out.println("Student updated successfully!");
            break;
        }
    }

    if (!found) {
        System.out.println("Student with ID " + id + " not found.");
    }
}
    public static void deleteStudent() {
        if (students.isEmpty()) {
            System.out.println("No students to delete.");
            return;
        }

        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();

        boolean removed = false;

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).id == id) {
                students.remove(i);
                removed = true;
                System.out.println("Student deleted successfully!");
                break;
            }
        }

        if (!removed) {
            System.out.println("Student with ID " + id + " not found.");
        }
    }
}

    

        
    


