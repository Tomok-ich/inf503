package lambda;

public class Student {
    private String name;
    private String group;
    private String birthDate;

    public Student(String name, String group, String birthDate) {
        this.name = name;
        this.group = group;
        this.birthDate = birthDate;
    }

    public void work(StudentWork studentWork, String work) {
        studentWork.doWork(name, work);
    }

}