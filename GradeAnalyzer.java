import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class GradeAnalyzer {
    public static void main(String[] args) throws IOException {
        ArrayList<Course> courses = new ArrayList<>();
        File file = new File("courseAndGradesData.csv");
        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String[] parts = line.split(",");
            String name = parts[0];
            int a = Integer.parseInt(parts[1]);
            int b = Integer.parseInt(parts[2]);
            int c = Integer.parseInt(parts[3]);
            int d = Integer.parseInt(parts[4]);
            int f = Integer.parseInt(parts[5]);
            courses.add(new Course(name, a, b, c, d, f));
        }
        fileScanner.close();
        System.out.printf("%-10s %4s %4s %4s %4s %4s %7s%n",
                "Course", "A", "B", "C", "D", "F", "%A");
        System.out.println("------------------------------------------------");
        Course highestA = courses.get(0);
        for (Course c : courses) {
            System.out.printf("%-10s %4d %4d %4d %4d %4d %6.2f%%%n",
                    c.getCourseName(),
                    c.getNumA(),
                    c.getNumB(),
                    c.getNumC(),
                    c.getNumD(),
                    c.getNumF(),
                    c.getPercentA());
            if (c.getPercentA() > highestA.getPercentA()) {
                highestA = c;
            }
        }
        System.out.printf("%nHighest %% of A grades: %s (%.2f%%)%n%n",
                highestA.getCourseName(), highestA.getPercentA());
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a course to search: ");
        String search = input.nextLine();
        boolean found = false;
        for (Course c : courses) {
            if (c.getCourseName().equalsIgnoreCase(search)) {
                System.out.println("\nCourse Found:");
                System.out.println("Course: " + c.getCourseName());
                System.out.println("A: " + c.getNumA());
                System.out.println("B: " + c.getNumB());
                System.out.println("C: " + c.getNumC());
                System.out.println("D: " + c.getNumD());
                System.out.println("F: " + c.getNumF());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Course not found.");
        }
        input.close();
    }
}
