public class Course
{
    private String courseName;
    private double midtermGrade;
    private double finalGrade;

    public Course(String courseName, double midtermGrade, double finalGrade) {
        this.courseName = courseName;
        this.midtermGrade = midtermGrade;
        this.finalGrade = finalGrade;
    }

    public double calculateAverage() {
        return ((midtermGrade*4)/10 + ((finalGrade*6)/10));
    }

    @Override
    public String toString() {
        double average = calculateAverage();
        return courseName + ": Vize=" + midtermGrade + ", Final=" + finalGrade + ", Ortalama=" + average;
    }
}
