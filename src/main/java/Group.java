import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Group {
    @Id
    private String name;
    @OneToMany(targetEntity=Student.class, mappedBy="students",
            fetch=FetchType.EAGER)
    private List<Student> students = new ArrayList<>();

    public Group(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Group{" +
                ", name='" + name + '\'' +
                ", students=" + students +
                '}';
    }
}
