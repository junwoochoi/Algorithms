package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1427
 * 백준 소트 인 사이트
 */
public class Baekjoon1427 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input = br.readLine();

        int[] numbers = new int[input.length()];
        int[] counting = new int[10];
        int i = 0;
        for (char c : input.toCharArray()) {
            numbers[i] = Character.getNumericValue(c);
            counting[numbers[i++]]++;
        }

        int sum = 0;
        for (int j = 0; j < 10; j++) {
            sum += counting[j];
            counting[j] = sum;
        }

        int[] sorted = new int[numbers.length];
        for (int j = numbers.length - 1; j >= 0; j--) {
            if (counting[numbers[j]] == 0) continue;
            int index = counting[numbers[j]] - 1;
            counting[numbers[j]]--;
            sorted[index] = numbers[j];
        }

        StringBuilder sb = new StringBuilder();
        for (int j = numbers.length - 1; j >= 0; j--) {
            sb.append(sorted[j]);
        }

        System.out.println(sb.toString());
    }
}
