package homework;

public class Student {
    private String name;
    private String group;
    private double middleRating;
    private int count;

    Student(String name, String group) {
        this.middleRating = 0;
        this.count = 0;
        this.name = name;
        this.group = group;
    }

    public void addRating(int rating) {
        this.count+=1;
        this.middleRating = (this.middleRating + rating)/count;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", middleRating=" + middleRating +
                ", count=" + count +
                '}';
    }
}