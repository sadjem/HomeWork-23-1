import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Group javaGroup = createJavaGroup();
        Group jsGroup = createJsGroup();

        try {
            UserDao userDao = new UserDao();
            userDao.insertGroup(javaGroup);
            userDao.insertGroup(jsGroup);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Group createJavaGroup() {
        Group group = new Group(Helper.generateId(), "Java");
        group.addStudent(new Student(Helper.generateId(), "Alex", 26));
        group.addStudent(new Student(Helper.generateId(), "Oleg", 28));
        group.addStudent(new Student(Helper.generateId(), "Igor", 15));
        return group;
    }

    private static Group createJsGroup() {
        Group group = new Group(Helper.generateId(), "Js");
        group.addStudent(new Student(Helper.generateId(), "Sofia", 26));
        group.addStudent(new Student(Helper.generateId(), "Alex", 27));
        group.addStudent(new Student(Helper.generateId(), "Emilia", 30));
        return group;
    }
}
