package academic.driver;
/**
 * @author 12S24042 Ventyola Rohati Napitupulu
 */
import academic.model.Course;
import java.util.Scanner;

public class Driver1 {

    private static final int INITIAL_CAPACITY = 10;
    private static Course[] courses = new Course[INITIAL_CAPACITY];
    private static int courseCount = 0;

    public static void main(String[] _args) { // Changed String[] args to String[] _args
        Scanner input = new Scanner(System.in);
        String line;

        System.out.println("Enter course data (format: code#name#credits#passingGrade, type '---' to stop):");

        while (input.hasNextLine()) {
            line = input.nextLine();
            if (line.equals("---")) {
                break;
            }

            String[] data = line.split("#");
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
                System.err.println("Warning: Invalid input format. Expected 4 segments for Course. Skipping line: " + line);
            }
        }

        // Outputting stored courses as per the Driver1 example output
        for (int i = 0; i < courseCount; i++) {
            System.out.println(courses[i]);
        }
        
        input.close();
    }

    private static void addCourse(Course course) {
        if (courseCount == courses.length) {
            Course[] newCourses = new Course[courses.length * 2];
            System.arraycopy(courses, 0, newCourses, 0, courses.length);
            courses = newCourses;
        }
        courses[courseCount++] = course;
    }
}
