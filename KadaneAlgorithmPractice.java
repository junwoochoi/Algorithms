package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 * https://algospot.com/judge/problem/read/MAXSUM
 * 
 * @author jwoochoi 연속 부분합 구하기 카데인 알고리즘 연습! Kadane Algorithm
 */
public class KadaneAlgorithmPractice {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		for (int j = 0; j < count; j++) {

			int length = Integer.parseInt(br.readLine());

			Vector<Integer> input = new Vector<>();
			Vector<Integer> sum = new Vector<>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			while (st.hasMoreTokens()) {
				input.add(Integer.parseInt(st.nextToken()));
			}
			int max = input.get(0);
			sum.add(input.get(0));
			for (int i = 1; i < length; i++) {
				int temp = Math.max(input.get(i), sum.get(i - 1) + input.get(i));
				sum.add(temp);
				max = Math.max(temp, max);
			}
			System.out.println(max);

		}
	}
}
