package algo;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class tes {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = Integer.parseInt(sc.nextLine());
		while(test-->0) {
			
		int count = Integer.parseInt(sc.nextLine());
		int[][] hell = new int[count][count];
		int i = 0;
		while (count-- > 0) {
			StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
			int j = 0;
			while (st.hasMoreTokens()) {
				hell[i][j++] = Integer.parseInt(st.nextToken());
			}
			i++;
		}

		findMaxSubMatrix(hell);
		}
	}

	/**
	 * To find maxSum in 1d array
	 * 
	 * return {maxSum, left, right}
	 */
	public static int[] kadane(int[] a) {
//result[0] == maxSum, result[1] == start, result[2] == end; 
		int[] result = new int[] { Integer.MIN_VALUE, 0, -1 };
		int currentSum = 0;
		int localStart = 0;

		for (int i = 0; i < a.length; i++) {
			currentSum += a[i];
			if (currentSum < 0) {
				currentSum = 0;
				localStart = i + 1;
			} else if (currentSum > result[0]) {
				result[0] = currentSum;
				result[1] = localStart;
				result[2] = i;
			}
		}

//all numbers in a are negative 
		if (result[2] == -1) {
			result[0] = Integer.MIN_VALUE;
			for (int i = 0; i < a.length; i++) {
				if (a[i] > result[0]) {
					result[0] = a[i];
					result[1] = i;
					result[2] = i;
				}
			}
		}

		return result;
	}

	/**
	 * To find and print maxSum, (left, top),(right, bottom)
	 */
	public static void findMaxSubMatrix(int[][] a) {
		int cols = a[0].length;
		int rows = a.length;
		int[] currentResult;
		int maxSum = Integer.MIN_VALUE;
		int left = 0;
		int top = 0;
		int right = 0;
		int bottom = 0;
		for (int leftCol = 0; leftCol < cols; leftCol++) {
			int[] tmp = new int[rows];

			for (int rightCol = leftCol; rightCol < cols; rightCol++) {

				for (int i = 0; i < rows; i++) {
					tmp[i] += a[i][rightCol];
				}
	
			
				currentResult = kadane(tmp);
				if (currentResult[0] > maxSum) {
					maxSum = currentResult[0];
					left = leftCol;
					top = currentResult[1];
					right = rightCol;
					bottom = currentResult[2];
				}
			}
		}
		System.out.println(maxSum);

	}
}
