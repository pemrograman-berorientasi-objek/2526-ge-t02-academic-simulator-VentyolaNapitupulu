package academic.driver;
import academic.model.Enrollment;
import java.util.Scanner;

/**
 * @author 12S24042 Ventyola Rohati Napitupulu
 */
public class Driver3 {

    public static void main(String[] _args) {

        Scanner scanner = new Scanner(System.in);
        Enrollment[] enrollments = new Enrollment[100];
        int count = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("---")) break;
            String[] parts = line.split("#");
            String courseCode = parts[0];
            String studentNim = parts[1];
            String academicYear = parts[2];
            String semester = parts[3];
            enrollments[count++] = new Enrollment(courseCode, studentNim, academicYear, semester);
        }

        for (int i = 0; i < count; i++) {
            System.out.println(enrollments[i]);
        }

    }

}
