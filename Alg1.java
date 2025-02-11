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

    public int divideConquer(int[] a, int n) {
        submax(int[] a, int low, int high) {
            if (high == low) {
                return a[low];
            }
            else {
                mid = Math.floorDiv(low + high, 2);
                leftsum = submax(a, low, mid);
                rightsum = submax(a, mid + 1, high);
                crosssum = crossingsub(a, low, mid, high);
            }
        }

        crossingsub(int[] a, low, mid, high) {
            for (int i = mid; i < low; i++) {
                sum += a[i];
                if (sum > leftsum) {
                    leftsum == sum;
                }
            }
            for (int j = mid + 1; j < high; j++) {
                sum += a[j];
                if (sum > rightsum) {
                    rightsum == sum;
                }
            }
            return leftsum + rightsum;
        }
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
        System.out.println("Brute Force Algorithm\n-----------\nMaximum subarray sum: " + maxSum + "\nThe time it took (nanoseconds) was: " + totalTime);
        long startTime2 = System.nanoTime();
        int maxSum2 = alg.divideConquer(a, n);
        long endTime2 = System.nanoTime();
        long totalTime2 = endTime2 - startTime2;
        System.out.println("Divide and Conquer Algorithm\n-----------\nMaximum subarray sum: " + maxSum + "\nThe time it took (nanoseconds) was: " + totalTime);
        scan.close();
    }
}