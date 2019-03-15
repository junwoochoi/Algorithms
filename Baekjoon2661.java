package algo.Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/2661
 * 백준 2661번 좋은 수열
 */
public class Baekjoon2661 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] numbers = {1, 2, 3};
    static int M;
    static boolean flag = false;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        M = Integer.parseInt(br.readLine());
        answer.append(numbers[0]);
        dfs(0);

    }

    private static void dfs(int i) {
        if(isBad() || flag) return;


        if (answer.length() == M) {
            flag = true;
            System.out.println(answer.toString());
            return;
        }

        for (int j = 0; j < 3; j++) {
            int next = j;

            if(next == i) continue;

            answer.append(numbers[next]);

            dfs(next);

            answer.delete(answer.length() - 1, answer.length());
        }
    }

    private static boolean isBad() {
        String str = answer.toString();

        if(str.length()==1) return false;

        for (int i = str.length()-1; i > 0 ; i--) {
            String pivot = str.substring(i);
            if(i-pivot.length()<0) continue;
            String check = str.substring(i-pivot.length(), i);
            if(pivot.equals(check)){
                return true;
            }
        }

        return false;
    }
}
