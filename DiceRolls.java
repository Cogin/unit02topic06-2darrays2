public class DiceRolls {

    public static void expectedtwoD6Probabilities() {
        double[] expected = new double[13];
        int[] frequencies = new int[13];
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                frequencies[i+j]++;
            }
        }
        double[] probabilities = new double[13];
        for (int k = 1; k <= 12; k++) {
        probabilities[k] = frequencies[k] / 36.0;
}

        System.out.println("Sum\tCount\tAverage\tPercent");
        for (int i = 0; i < 13; i++) {
            System.out.println(i + "\t" + frequencies[i] + "\t" + probabilities[i] + "\t" + (probabilities[i] * 100) + "%");
        }
    }

    public static void twoD6Probabilities(int nTrials) {
        int[] counts = new int[13];
        for (int i = 0; i < nTrials; i++) {
            int roll1 = (int) (Math.random() * 6) + 1;
            int roll2 = (int) (Math.random() * 6) + 1;
            int sum = roll1 + roll2;
            counts[sum]++;
        }
        
        double[] averages = new double[13];
        for (int i = 0; i < 13; i++) {
            averages[i] = (double) counts[i] / nTrials;
        }

        System.out.println("Sum\tCount\tAverage\tPercent");
        for (int i = 0; i < 13; i++) {
            System.out.println(i + "\t" + counts[i] + "\t" + averages[i] + "\t" + (averages[i] * 100) + "%");
        }
    }

    public static void main(String[] args) {
        twoD6Probabilities(10000);
    }
}
