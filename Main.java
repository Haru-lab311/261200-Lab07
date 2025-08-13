
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentGrades grades = new StudentGrades();

        try {
            System.out.println("Enter scores (comma-separated): ");
            String input = scanner.nextLine();

            if (input.isEmpty()) {
                throw new IllegalArgumentException("Scores array cannot be empty.");
            }

            String[] parts = input.split(",");
            int[] scores = new int[parts.length];

            for (int i = 0; i < parts.length; i++) {
                scores[i] = Integer.parseInt(parts[i]);
            }
            double average = grades.calculateAverage(scores);
            System.out.println("Average score: " + average);

        } catch (NumberFormatException ex) {
            System.out.println("Invalid input: Please enter a valid number for scores. " + ex.getMessage());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        } catch (FailedSignificantlyException ex) {
            System.out.println("Significant Failure: " + ex.getMessage());
        } finally {
            scanner.close();
            System.out.println("Grade calculation process concluded.");
        }
    }
}
