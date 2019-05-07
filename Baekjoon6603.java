package Algorithms;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/6603
 * 백준 6603번 로또
 */
public class Baekjoon6603 {
    private static int[] numbers;
    private static int[] combi;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        while (!input.equals("0")) {
            StringTokenizer st = new StringTokenizer(input);
            int length = Integer.parseInt(st.nextToken());
            numbers = new int[length];
            combi = new int[6];


            for (int i = 0; i < length; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }



            for (int i = 0; i < numbers.length; i++) {
                combi[0] = numbers[i];
                lotto(i, 1);
                combi[0] = 0;
            }

            System.out.println("");


            input = br.readLine();
        }
    }

    private static void lotto(int num, int depth) {
        if (depth == 6) {
            StringBuilder sb = new StringBuilder();
            for (int number : combi) {
                sb.append(number).append(" ");
            }
            System.out.println(sb.toString().trim());
            return;
        }

        for (int i = num+1; i < numbers.length; i++) {
            combi[depth] = numbers[i];
            lotto(i, depth+1);
            combi[depth] = 0;
        }

    }
}
