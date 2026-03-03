package academic.driver;
/**
 * @author 12S24042 Ventyola Rohati Napitupulu
 */
import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.Scanner;

public class Driver4 {

    private static final int INITIAL_CAPACITY = 10;

    private static Course[] courses = new Course[INITIAL_CAPACITY];
    private static int courseCount = 0;

    private static Student[] students = new Student[INITIAL_CAPACITY];
    private static int studentCount = 0;

    private static Enrollment[] enrollments = new Enrollment[INITIAL_CAPACITY];
    private static int enrollmentCount = 0;

    public static void main(String[] _args) { // Changed String[] args to String[] _args
        Scanner input = new Scanner(System.in);
        String line;

        System.out.println("Enter academic data (format: type#data, e.g., course-add#code#name#credits#passingGrade, type '---' to stop):");

        while (input.hasNextLine()) {
            line = input.nextLine();
            if (line.equals("---")) {
                break;
            }

            String[] parts = line.split("#", 2); 
            if (parts.length < 2) {
                System.err.println("Warning: Invalid input format. Expected 'type#data'. Skipping line: " + line);
                continue;
            }

            String type = parts[0].trim();
            String dataString = parts[1].trim();
            String[] data = dataString.split("#"); 

            switch (type) {
                case "course-add":
                    if (data.length == 4) {
                        try {
                            String code = data[0];
                            String name = data[1];
                            int credits = Integer.parseInt(data[2]);
                            String passingGrade = data[3];

                            Course newCourse = new Course(code, name, credits, passingGrade);
                            addCourse(newCourse);
                        } catch (NumberFormatException e) {
                            System.err.println("Error parsing credits: " + e.getMessage() + ". Skipping line: " + line);
                        } catch (IllegalArgumentException e) {
                            System.err.println("Error creating course: " + e.getMessage() + ". Skipping line: " + line);
                        }
                    } else {
                        System.err.println("Warning: Invalid input format for Course. Expected 4 segments after 'course-add#'. Skipping line: " + line);
                    }
                    break;
                case "student-add":
                    if (data.length == 4) { 
                        String id = data[0];
                        String name = data[1];
                        String entryYear = data[2];
                        String major = data[3]; 

                        Student newStudent = new Student(id, name, entryYear, major);
                        addStudent(newStudent);
                    } else {
                        System.err.println("Warning: Invalid input format for Student. Expected 4 segments after 'student-add#'. Skipping line: " + line);
                    }
                    break;
                case "enrollment-add":
                    if (data.length == 4) { 
                        String courseCode = data[0];
                        String studentId = data[1];
                        String academicYear = data[2]; 
                        String semester = data[3];     
                        String grade = ""; // Grade is not explicitly in input, will default to "None"

                        Student student = findStudentById(studentId);
                        Course course = findCourseByCode(courseCode);

                        if (student == null) {
                            System.err.println("Error: Student with ID '" + studentId + "' not found for enrollment. Skipping line: " + line);
                            continue;
                        }
                        if (course == null) {
                            System.err.println("Error: Course with code '" + courseCode + "' not found for enrollment. Skipping line: " + line);
                            continue;
                        }

                        try {
                            Enrollment newEnrollment = new Enrollment(student, course, academicYear, semester, grade); 
                            addEnrollment(newEnrollment);
                        } catch (IllegalArgumentException e) {
                            System.err.println("Error creating enrollment: " + e.getMessage() + ". Skipping line: " + line);
                        }
                    } else {
                        System.err.println("Warning: Invalid input format for Enrollment. Expected 4 segments after 'enrollment-add#'. Skipping line: " + line);
                    }
                    break;
                default:
                    System.err.println("Warning: Unknown command type '" + type + "'. Skipping line: " + line);
                    break;
            }
        }
        
        input.close();

        // --- Output all data in specified order ---
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

    private static void addCourse(Course course) {
        if (courseCount == courses.length) {
            Course[] newCourses = new Course[courses.length * 2];
            System.arraycopy(courses, 0, newCourses, 0, courses.length);
            courses = newCourses;
        }
        courses[courseCount++] = course;
    }

    private static void addStudent(Student student) {
        if (studentCount == students.length) {
            Student[] newStudents = new Student[students.length * 2];
            System.arraycopy(students, 0, newStudents, 0, students.length);
            students = newStudents;
        }
        students[studentCount++] = student;
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
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getId().equals(id)) {
                return students[i];
            }
        }
        return null;
    }

    private static Course findCourseByCode(String code) {
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].getCode().equals(code)) {
                return courses[i];
            }
        }
        return null;
    }
}
