package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://algospot.com/judge/problem/read/MAXMAT
 * 
 * @author jwoochoi 합이 최대가 되는 부분 집합 찾기
 */
public class MaxMatrix {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		for (int i = 0; i < testCase; i++) {
			int length = Integer.parseInt(br.readLine());
			int inputMatrix[][] = new int[length][length];

			for (int j = 0; j < length; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int m = 0;
				while (st.hasMoreTokens()) {
					inputMatrix[j][m++] = Integer.parseInt(st.nextToken());
				}
			}

			int answer = Integer.MIN_VALUE;

			for (int leftCol = 0; leftCol < length; leftCol++) {
				int[] temp = new int[length];
				for (int rightCol = leftCol; rightCol < length; rightCol++) {
					for (int k = 0; k < length; k++) {
						temp[k] += inputMatrix[k][rightCol];
					}
					int max = kadane(temp);
					if (max > answer) {
						answer = max;
					}
				}
			}
			System.out.println(answer);

		}
	}

	private static int kadane(int[] arr) {
		int[] temp = arr.clone();
		int max = temp[0];
		for (int i = 1; i < temp.length; i++) {
			temp[i] = Math.max(temp[i], temp[i] + temp[i - 1]);
			if (temp[i] > max) {
				max = temp[i];
			}
		}
		return max;
	}

}
