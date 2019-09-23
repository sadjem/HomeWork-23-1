import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Java")
public class Java {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    private List<Student> students;
}
