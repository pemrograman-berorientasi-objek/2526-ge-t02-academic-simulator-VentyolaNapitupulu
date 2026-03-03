package academic.driver;
/**
 * @author 12S24042 Ventyola Rohati Napitupulu
 */
import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.Scanner;

public class Driver3 {

    private static final int INITIAL_CAPACITY = 10;
    private static Enrollment[] enrollments = new Enrollment[INITIAL_CAPACITY];
    private static int enrollmentCount = 0;

    // Dummy data for Courses and Students to enable Enrollment creation for demonstration
    private static Course[] dummyCourses = {
        new Course("12S2203", "Object-oriented Programming", 3, "C"),
        new Course("10S1002", "Pemrograman Prosedural", 2, "D")
    };
    private static Student[] dummyStudents = {
        new Student("12S20999", "Wiro Sableng", "2020", "Information Systems"),
        new Student("12S20111", "Jaka Sembung", "2019", "Information Systems")
    };


    public static void main(String[] _args) { // Changed String[] args to String[] _args
        Scanner input = new Scanner(System.in);
        String line;

        System.out.println("Enter enrollment data (format: courseCode#studentId#academicYear#semester, type '---' to stop):");

        while (input.hasNextLine()) {
            line = input.nextLine();
            if (line.equals("---")) {
                break;
            }

            String[] data = line.split("#");
            if (data.length == 4) {
                String courseCode = data[0];
                String studentId = data[1];
                String academicYear = data[2]; 
                String semester = data[3];     
                String grade = ""; // Grade is not in input, will default to "None" in Enrollment class

                Student student = findStudentById(studentId);
                Course course = findCourseByCode(courseCode);

                if (student == null) {
                    System.err.println("Error: Student with ID '" + studentId + "' not found. Skipping enrollment for line: " + line);
                    continue;
                }
                if (course == null) {
                    System.err.println("Error: Course with code '" + courseCode + "' not found. Skipping enrollment for line: " + line);
                    continue;
                }

                try {
                    Enrollment newEnrollment = new Enrollment(student, course, academicYear, semester, grade);
                    addEnrollment(newEnrollment);
                } catch (IllegalArgumentException e) {
                    System.err.println("Error creating enrollment: " + e.getMessage() + ". Skipping line: " + line);
                }

            } else {
                System.err.println("Warning: Invalid input format. Expected 4 segments for Enrollment. Skipping line: " + line);
            }
        }

        for (int i = 0; i < enrollmentCount; i++) {
            System.out.println(enrollments[i]);
        }
        
        input.close();
    }

    private static void addEnrollment(Enrollment enrollment) {
        if (enrollmentCount == enrollments.length) {
            Enrollment[] newEnrollments = new Enrollment[enrollments.length * 2];
            System.arraycopy(enrollments, 0, newEnrollments, 0, enrollments.length);
            enrollments = newEnrollments;
        }
        enrollments[enrollmentCount++] = enrollment;
    }

    private static Student findStudentById(String id) {
        for (Student s : dummyStudents) {
            if (s.getId().equals(id)) {
                return s;
            }
        }
        return null;
    }

    private static Course findCourseByCode(String code) {
        for (Course c : dummyCourses) {
            if (c.getCode().equals(code)) {
                return c;
            }
        }
        return null;
    }
}
