import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {
    private Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public UserDao() throws SQLException {
        connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/test2",
                "postgres",
                "");
        createGroupTable();
        createStudentTable();
    }

    private void createStudentTable() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS groups (\n" +
                    "_id uuid PRIMARY KEY,\n" +
                    "name varchar(100)\n" +
                    ");");
        }
    }

    private void createGroupTable() throws SQLException {
        try(Statement statement = connection.createStatement()){
            statement.execute("CREATE TABLE IF NOT EXISTS students (\n" +
                    "id uuid PRIMARY KEY, \n" +
                    "name varchar(100), \n" +
                    "age int\n" +
                    ");");
        }
    }
    protected void insertGroup(Group group) throws SQLException {
        try(Statement statement = connection.createStatement()){
            String request = String.format("INSERT INTO groups VALUES ('%s', '%s');", group.getId(), group.getName());
            statement.execute(request);
            for(Student student : group.getStudents()){
                student.setGroupId(group.getId());
                insertStudent(student);
            }
        }
    }

    private void insertStudent(Student student) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String request = String.format("INSERT INTO students VALUES ('%s', '%s', '%s', '%d');",
                    student.getId(), student.getGroupId(), student.getName(), student.getAge());
            statement.execute(request);
        }
    }
}
