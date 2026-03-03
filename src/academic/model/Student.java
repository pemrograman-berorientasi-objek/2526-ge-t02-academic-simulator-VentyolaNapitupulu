package academic.model;
/**
 * @author 12S24042 Ventyola Rohati Napitupulu
 */
public class Student {

    private String nim;
    private String name;
    private int year;
    private String major;

    public Student(String nim, String name, int year, String major) {
        this.nim = nim;
        this.name = name;
        this.year = year;
        this.major = major;
    }

    public String getNim() { return nim; }
    public String getName() { return name; }
    public int getYear() { return year; }
    public String getMajor() { return major; }

    @Override
    public String toString() {
        return nim + "|" + name + "|" + year + "|" + major;
    }

}
