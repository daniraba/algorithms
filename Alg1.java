import java.util.Scanner;
import java.util.Random;

public class Alg1 {
    private int sum, submax;

    public static int bruteForce(int[] a, int n) {
        int submax = Integer.MIN_VALUE; // Initialize submax

        for (int i = 1; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += a[j];
                submax = Math.max(submax, sum);
            }
        }
        return submax;
    }

    public static int divideConquer(int[] a, int low, int high) {
        if (low == high) {
            return a[low];
        }
        
        int mid = Math.floorDiv(low + high, 2);
        int leftSum = divideConquer(a, low, mid);
        int rightSum = divideConquer(a, mid + 1, high);
        int crossSum = crossingSub(a, low, mid, high);

        return Math.max(Math.max(leftSum, rightSum), crossSum);
    }

    

    public static int crossingSub(int[] a, int low, int mid, int high) {
        int leftSum = Integer.MIN_VALUE, sum = 0; 
        for (int i = mid; i >= low; i--) {
            sum += a[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        for (int j = mid + 1; j <= high; j++) {
            sum += a[j];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }
        return leftSum + rightSum;
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

        //Brute force
        long startTime = System.nanoTime();
        int maxSum = alg.bruteForce(a, n);
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Brute Force Algorithm\n-----------\nMaximum subarray sum: " + maxSum + "\nThe time it took (nanoseconds) was: " + totalTime);
        
        //Divide and conquer
        long startTime2 = System.nanoTime();
        int maxSum2 = alg.divideConquer(a, 0, n-1);
        long endTime2 = System.nanoTime();
        long totalTime2 = endTime2 - startTime2;
        System.out.println("Divide and Conquer Algorithm\n-----------\nMaximum subarray sum: " + maxSum2 + "\nThe time it took (nanoseconds) was: " + totalTime);
        scan.close();
    }
}