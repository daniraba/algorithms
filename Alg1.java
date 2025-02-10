import java.util.Scanner;


public class Alg1 {
    int sum, n, submax;
    long totalTime, endTime, startTime;


    private class BruteForce {
        for (int i = 1; i <= n; i++) {
            sum = 0;
            for (int j = i; j <= n; j++) {
                sum = sum + a.get(j);
                submax = Math.max(submax, sum);
            }
        }
        return submax;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        Scanner scan = new Scanner(System.in);
        Integer n = scan.nextInt();
        int[] a = new int[n];
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("The time it took was: " + totalTime);

    }
}