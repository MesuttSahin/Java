import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Map<String, Course> courses = new HashMap<>();

        System.out.print("Kaç ders gireceksiniz? ");
        int numberOfCourses = scanner.nextInt();
        scanner.nextLine(); // Buffer temizleme

        for (int i = 0; i < numberOfCourses; i++) {
            System.out.print("Ders adı: ");
            String courseName = scanner.nextLine();

            System.out.print("Vize notu: ");
            double midtermGrade = scanner.nextDouble();

            System.out.print("Final notu: ");
            double finalGrade = scanner.nextDouble();
            scanner.nextLine(); // Buffer temizleme

            Course course = new Course(courseName, midtermGrade, finalGrade);
            courses.put(courseName, course);
        }

        System.out.println("\nDerslerin Notları:");
        for (Course course : courses.values()) {
            System.out.println(course);
        }
    }
}