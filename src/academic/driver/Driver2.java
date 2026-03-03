package academic.driver;
import academic.model.Student;
import java.util.Scanner;

/**
 * @author 12S24042 Ventyola Rohati Napitupulu
 */
public class Driver2 {

    public static void main(String[] _args) {

        Scanner scanner = new Scanner(System.in);
        Student[] students = new Student[100];
        int count = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("---")) break;
            String[] parts = line.split("#");
            String nim = parts[0];
            String name = parts[1];
            int year = Integer.parseInt(parts[2]);
            String major = parts[3];
            students[count++] = new Student(nim, name, year, major);
        }

        for (int i = 0; i < count; i++) {
            System.out.println(students[i]);
        }

    }

}
