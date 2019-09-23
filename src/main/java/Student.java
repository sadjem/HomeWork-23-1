import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Students")
public class Student {
    @Id
    private String name;
    private int age;
    @OneToMany(targetEntity=Group.class, mappedBy="groups",
            fetch=FetchType.EAGER)
    private List<Group> groups = new ArrayList<>();

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "Student{"
                + ", name='" + name + '\'' +
                ", age=" + age +
                ", groups=" + groups +
                '}';
    }
}
