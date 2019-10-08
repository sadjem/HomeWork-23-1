import java.util.ArrayList;
import java.util.List;

public class Group {
    private String id;
    private String name;
    private List<Student> students = new ArrayList<>();

    public Group(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Group(String id, String name, List<Student> users) {
        this.id = id;
        this.name = name;
        this.students = users;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", students=" + students +
                '}';
    }
}
