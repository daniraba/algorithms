import java.util.Scanner;
import java.util.Random;

public class Alg1 {
    private int sum, submax;

    public int bruteForce(int[] a, int n) {
        submax = Integer.MIN_VALUE; // Initialize submax

        for (int i = 1; i < n; i++) {
            sum = 0;
            for (int j = i; j < n; j++) {
                sum += a[j];
                submax = Math.max(submax, sum);
            }
        }
        return submax;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Enter the array size.");
        int n = scan.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = rand.nextInt(21) - 10; // Generate random values between -10 and 10 for elements in array n
        }
        Alg1 alg = new Alg1();
        long startTime = System.nanoTime();
        int maxSum = alg.bruteForce(a, n);
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Maximum subarray sum: " + maxSum + "\nThe time it took (nanoseconds) was: " + totalTime);
        scan.close();
    }
}