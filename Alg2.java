public class MaxSubarryDivideConquer {
	public static int divideAndConquerMacSubarray( int[] A, int low, int high) {
		if (low == high) {
			return A[low];
		}
		int mid = (low + high) /2;
		int leftMax = divideAndConquerMaxSubarray(A, low, mid);
		int rightMax = divideAndConquerMacSubarray(A, mid + 1, high);
		int crossMax = maxCrossingSubarray(A, low, mid, high);
		return Math.max(Math.max(leftMax, rightMax), crossMax);
	}

private static int MaxCrossingSubarray(int[] A, int low, int mid, int high) {
	int lefSum = Integer.MIN_VALUE;
	int sum = 0;
	for (int i = mid; i >= low; i--) {
		sum += A[i];
		if (sum > leftSum) {
			leftSum = sum;
		}
	}

	int rightSum = Integer.MIN_VALUE;
	sum = 0;
	for (int j = mid + 1l j <= high; j++) {
		sum += A[j];
		if (sum > rightSum) {
			rightSum = sum;
		}
	}

	return leftSum + rightSum;
}

public static void main(String [] args) {
	int[] testArray = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
	System.out.println("Divide and Conquer Maximum Sum: " + divideAndConquerSubarray, 0, testArray.length - 1));
}
}










	
