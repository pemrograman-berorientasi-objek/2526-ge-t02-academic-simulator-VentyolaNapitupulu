package academic.driver;
/**
 * @author 12S24042 Ventyola Rohati Napitupulu
 */
import academic.model.Student;
import java.util.Scanner;

public class Driver2 {

    private static final int INITIAL_CAPACITY = 10;
    private static Student[] students = new Student[INITIAL_CAPACITY];
    private static int studentCount = 0;

    public static void main(String[] _args) { // Changed String[] args to String[] _args
        Scanner input = new Scanner(System.in);
        String line;

        System.out.println("Enter student data (format: id#name#entryYear#major, type '---' to stop):");

        while (input.hasNextLine()) {
            line = input.nextLine();
            if (line.equals("---")) {
                break;
            }

            String[] data = line.split("#");
            if (data.length == 4) {
                String id = data[0];
                String name = data[1];
                String entryYear = data[2];
                String major = data[3]; 

                Student newStudent = new Student(id, name, entryYear, major); 
                addStudent(newStudent);
            } else {
                System.err.println("Warning: Invalid input format. Expected 4 segments for Student. Skipping line: " + line);
            }
        }

        for (int i = 0; i < studentCount; i++) {
            System.out.println(students[i]);
        }
        
        input.close();
    }

    private static void addStudent(Student student) {
        if (studentCount == students.length) {
            Student[] newStudents = new Student[students.length * 2];
            System.arraycopy(students, 0, newStudents, 0, students.length);
            students = newStudents;
        }
        students[studentCount++] = student;
    }
}
