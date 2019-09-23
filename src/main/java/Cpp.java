import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Cpp")
public class Cpp {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    private List<Student> students;
}
