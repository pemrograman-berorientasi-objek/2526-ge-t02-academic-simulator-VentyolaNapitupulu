package academic.model;
/**
 * @author 12S24042 Ventyola Rohati Napitupulu
 */
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Enrollment {
    private Student student;
    private Course course;
    private String academicYear; 
    private String semester;     
    private String grade;

    private static final String DEFAULT_GRADE = "None";
    private static final Set<String> VALID_GRADES = new HashSet<>(Arrays.asList("A", "AB", "B", "C", "D", "E", DEFAULT_GRADE));

    public Enrollment(Student student, Course course, String academicYear, String semester, String grade) { 
        if (student == null || course == null) {
            throw new IllegalArgumentException("Student and Course cannot be null for Enrollment.");
        }
        this.student = student;
        this.course = course;
        this.academicYear = academicYear; 
        this.semester = semester;         
        setGrade(grade); // Use setter for validation
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public String getAcademicYear() { 
        return academicYear;
    }

    public String getSemester() {     
        return semester;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        if (grade == null || grade.trim().isEmpty()) {
            this.grade = DEFAULT_GRADE;
        } else if (!VALID_GRADES.contains(grade.toUpperCase())) {
            this.grade = DEFAULT_GRADE;
            // System.err.println("Warning: Invalid grade '" + grade + "' for enrollment. Setting to default 'None'."); // Can be uncommented for debugging
        } else {
            this.grade = grade.toUpperCase();
        }
    }
    
    public static boolean isValidGrade(String grade) {
        return VALID_GRADES.contains(grade.toUpperCase());
    }

    @Override
    public String toString() {
        // Updated toString to include academicYear, semester, and grade, matching new output examples
        // Format: CourseCode|StudentID|AcademicYear|Semester|Grade
        return course.getCode() + "|" + student.getId() + "|" + academicYear + "|" + semester + "|" + grade;
    }
}
