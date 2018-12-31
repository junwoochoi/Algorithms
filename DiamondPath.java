package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DiamondPath {
	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int count = Integer.parseInt(br.readLine());

		for (int i = 0; i < count; i++) {
			int btLength = Integer.parseInt(br.readLine());
			int[] initArr = new int[1];
			initArr[0] = Integer.parseInt(br.readLine());

			solveWithDP(initArr);

		}
	}
	public static int max(int a,int b) {
		return a > b ? a : b;
	}
	private static void solveWithDP(int[] beforeArr) throws IOException {
		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line, " ");
		int[] lineArr = new int[st.countTokens()];
		int j = 0;
		while (st.hasMoreTokens()) {
			lineArr[j++] = Integer.parseInt(st.nextToken());
		}

		int[] maxArr = new int[lineArr.length];
		if (maxArr.length > beforeArr.length) {
			for (int i = 0; i < lineArr.length; i++) {
				if (i == 0) {
					maxArr[i] = lineArr[i] + beforeArr[i];
				} else if (i == lineArr.length - 1) {
					maxArr[i] = lineArr[i]+ beforeArr[i - 1];
				} else {
					maxArr[i] = lineArr[i] + max(beforeArr[i - 1], beforeArr[i]);
				}
			}
		} else {
			for (int i = 0; i < lineArr.length; i++) {
				maxArr[i] = lineArr[i] + max(beforeArr[i], beforeArr[i + 1]);
			}
		}
		if (lineArr.length > 1) {
			solveWithDP(maxArr);
		} else {
			System.out.println(Arrays.stream(maxArr).max().getAsInt());
		}

	}

}
