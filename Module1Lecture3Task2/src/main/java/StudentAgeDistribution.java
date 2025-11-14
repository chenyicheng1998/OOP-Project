public class StudentAgeDistribution {
    public static void main(String[] args) {
        final int NUM_SIMULATIONS = 1000;
        final int MAX_AGE = 35;

        // Age distribution table: {cumulative percentage, age}
        int[][] ageDistribution = {
                {16, 20},   // 16% of students are age 20
                {34, 21},   // 18% of students are age 21 (34-16=18)
                {52, 22},   // 18% of students are age 22 (52-34=18)
                {68, 23},   // 16% of students are age 23 (68-52=16)
                {82, 24},   // 14% of students are age 24 (82-68=14)
                {89, 25},   // 7% of students are age 25 (89-82=7)
                {94, 26},   // 5% of students are age 26 (94-89=5)
                {96, 28},   // 2% of students are age 28 (96-94=2)
                {98, 30},   // 2% of students are age 30 (98-96=2)
                {100, 35}   // 2% of students are age 35 (100-98=2)
        };

        int[] generatedAges = new int[MAX_AGE + 1];

        // Test Run 1
        System.out.println("=== TEST RUN 1 ===");
        simulateAges(ageDistribution, generatedAges, NUM_SIMULATIONS);
        printResults(generatedAges, NUM_SIMULATIONS);

        // Reset for Test Run 2
        generatedAges = new int[MAX_AGE + 1];
        System.out.println("\n=== TEST RUN 2 (Different Random Sequence) ===");
        simulateAges(ageDistribution, generatedAges, NUM_SIMULATIONS);
        printResults(generatedAges, NUM_SIMULATIONS);
    }

    private static void simulateAges(int[][] distribution, int[] ageCounts, int iterations) {
        for (int i = 0; i < iterations; i++) {
            int randomNum = (int) (Math.random() * 100) + 1; // 1-100

            // Find the matching age category
            int age = findAgeForRandomNumber(distribution, randomNum);
            ageCounts[age]++;
        }
    }

    private static int findAgeForRandomNumber(int[][] distribution, int randomNum) {
        for (int i = 0; i < distribution.length; i++) {
            if (randomNum <= distribution[i][0]) {
                return distribution[i][1];
            }
        }
        return distribution[distribution.length - 1][1]; // Fallback
    }

    private static void printResults(int[] ageCounts, int total) {
        System.out.println("Age\tCount\tPercentage");
        System.out.println("---\t-----\t---------");

        for (int age = 0; age < ageCounts.length; age++) {
            if (ageCounts[age] > 0) {
                double percentage = (ageCounts[age] * 100.0) / total;
                System.out.printf("%d\t%d\t%.2f%%\n", age, ageCounts[age], percentage);
            }
        }
    }
}