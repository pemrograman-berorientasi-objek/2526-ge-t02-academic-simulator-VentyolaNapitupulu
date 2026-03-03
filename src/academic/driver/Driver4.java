package academic.driver;
/**
 * @author 12S24042 Ventyola Rohati Napitupulu
 */
import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.Scanner;

/**
 * @author NIM Nama
 * @author NIM Nama
 */
public class Driver4 {

    public static void main(String[] _args) {

        Scanner scanner = new Scanner(System.in);
        Course[] courses = new Course[100];
        Student[] students = new Student[100];
        Enrollment[] enrollments = new Enrollment[100];
        int courseCount = 0, studentCount = 0, enrollmentCount = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("---")) break;
            String[] parts = line.split("#");
            String type = parts[0];

            if (type.equals("course-add")) {
                String code = parts[1];
                String name = parts[2];
                int credits = Integer.parseInt(parts[3]);
                String grade = parts[4];
                courses[courseCount++] = new Course(code, name, credits, grade);
            } else if (type.equals("student-add")) {
                String nim = parts[1];
                String name = parts[2];
                int year = Integer.parseInt(parts[3]);
                String major = parts[4];
                students[studentCount++] = new Student(nim, name, year, major);
            } else if (type.equals("enrollment-add")) {
                String courseCode = parts[1];
                String studentNim = parts[2];
                String academicYear = parts[3];
                String semester = parts[4];
                enrollments[enrollmentCount++] = new Enrollment(courseCode, studentNim, academicYear, semester);
            }
        }

        for (int i = 0; i < courseCount; i++) {
            System.out.println(courses[i]);
        }
        for (int i = 0; i < studentCount; i++) {
            System.out.println(students[i]);
        }
        for (int i = 0; i < enrollmentCount; i++) {
            System.out.println(enrollments[i]);
        }

    }

}
