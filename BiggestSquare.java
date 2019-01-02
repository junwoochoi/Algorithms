package algo;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1915
 * 
 * @author jwoochoi 가장 큰 정사각형
 */
public class BiggestSquare {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] inputArr = new int[n + 1][m + 1];
		int[][] sumArr = new int[n + 1][m + 1];
		int answer = 0;
		for (int i = 1; i <= n; i++) {
			String input = sc.nextLine();
			char[] charArr = input.toCharArray();
			int j = 1;
			for (char c : charArr) {
				inputArr[i][j++] = Character.getNumericValue(c);
			}
		}
		

		for (int x = 1; x <= n; x++) {
			for (int y = 1; y <= m; y++) {

				if (inputArr[x][y] == 1) {
					sumArr[x][y] = Math.min(sumArr[x - 1][y],
							Math.min((sumArr[x][y - 1]), (sumArr[x - 1][y - 1]))) + 1;
					answer = Math.max(answer, sumArr[x][y]);
				}
			}
		}

		System.out.println(answer * answer);
		sc.close();
	}
}
