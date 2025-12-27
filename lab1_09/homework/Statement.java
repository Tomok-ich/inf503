package homework;

public class Statement {
    private Discipline discipline;
    private Student student;
    private double rating;
    private String date;
    private String comment;



    Statement(Discipline discipline, Student student, String date, String comment, int rating) {
        this.discipline = discipline;
        this.student = student;
        this.date = date;
        this.comment = comment;
        this.rating = rating;
        student.addRating(rating);

    }

    @Override
    public String toString() {
        return "Statement{" +
                "discipline=" + discipline +
                ", student=" + student +
                ", rating=" + rating +
                ", date='" + date + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
