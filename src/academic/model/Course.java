package academic.model;

/**
 * @author 12S24042 Ventyola Rohati Napitupulu
 */
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Course {
    private String code;
    private String name;
    private int credits; // SKS
    private String passingGrade;

    private static final Set<Integer> VALID_CREDITS = new HashSet<>(Arrays.asList(2, 3, 4));

    public Course(String code, String name, int credits, String passingGrade) {
        if (!VALID_CREDITS.contains(credits)) {
            // Throw error directly for invalid credits as per strong validation
            throw new IllegalArgumentException("Invalid credits. Must be 2, 3, or 4 for course " + code + ".");
        }
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.passingGrade = passingGrade; 
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public String getPassingGrade() {
        return passingGrade;
    }

    public static boolean isValidCredits(int credits) {
        return VALID_CREDITS.contains(credits);
    }

    @Override
    public String toString() {
        return code + "|" + name + "|" + credits + "|" + passingGrade;
    }
}
