public class StudentGrades {
    public double calculateAverage(int[] scores) {
        // Validation checks
        if (scores == null) {
            throw new IllegalArgumentException("Scores array cannot be null.");
        }
        if (scores.length == 0){
            throw new IllegalArgumentException("Scores array cannot be empty.");
        }
        for(int i = 0; i < scores.length; i++) {
            if (scores[i] < 0 || scores[i] > 100) {
                throw new IllegalArgumentException("Scores must be between 0 and 100. Invalid score: " + scores[i]);
            }
        }

        // Calculate average
        int sum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }
        double average = (double) sum / scores.length;

        if (average < 40) {
            throw new FailedSignificantlyException(
                    "Student average is " + average + ", which is a significant failure.");
        }
        return average;
    }
}
