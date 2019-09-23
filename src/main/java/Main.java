public class Main {
    public static void main(String[] args) {
        UserDao dao = new UserDao();
        Group java = new Group("Java");
        Group cpp = new Group("Cpp");
        Student st1 = new Student("Alex", 22);
        java.getStudents().add(st1);

        Student st2 = new Student("Ben", 33);
        java.getStudents().add(st2);

        Student st3 = new Student("Carl", 44);
        cpp.getStudents().add(st3);
        System.out.println(java);
        System.out.println(cpp);
       dao.addGroup(java);

        dao.close();
    }
}
