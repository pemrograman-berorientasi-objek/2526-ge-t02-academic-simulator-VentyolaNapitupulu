package academic.model;
/**
 * @author 12S24042 Ventyola Rohati Napitupulu
 */
public class Student {
    private String id;
    private String name;
    private String entryYear; // e.g., "2022"
    private String major; 

    public Student(String id, String name, String entryYear, String major) { 
        this.id = id;
        this.name = name;
        this.entryYear = entryYear;
        this.major = major; 
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEntryYear() {
        return entryYear;
    }

    public String getMajor() { 
        return major;
    }

    @Override
    public String toString() {
        return id + "|" + name + "|" + entryYear + "|" + major; 
    }
}
