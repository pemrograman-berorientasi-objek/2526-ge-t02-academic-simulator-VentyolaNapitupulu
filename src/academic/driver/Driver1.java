package academic.driver;
import academic.model.Course;
import java.util.Scanner;

/**
 * @author 12S24042 Ventyola Rohati Napitupulu
 */
public class Driver1 {

    public static void main(String[] _args) {

        Scanner scanner = new Scanner(System.in);
        Course[] courses = new Course[100];
        int count = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("---")) break;
            String[] parts = line.split("#");
            String code = parts[0];
            String name = parts[1];
            int credits = Integer.parseInt(parts[2]);
            String grade = parts[3];
            courses[count++] = new Course(code, name, credits, grade);
        }

        for (int i = 0; i < count; i++) {
            System.out.println(courses[i]);
        }

    }

}
