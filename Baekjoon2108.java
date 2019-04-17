package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2108
 * 백준 2108번 통계학
 */
public class Baekjoon2108 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] inputs = new int[N];
        int[] counting = new int[8001];
        int[] sorted = new int[N];

        double sumValue = 0;
        int frequentNumCnt = 1;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            sumValue += num;
            inputs[i] = num + 4000;
            counting[inputs[i]]++;
            frequentNumCnt = Math.max(frequentNumCnt, counting[inputs[i]]);
        }

        int frequentNum = 0;
        int temp = 0;
        int sum = 0;
        for (int i = 0; i < 8001; i++) {
            if (counting[i] == 0) continue;
            if (counting[i] == frequentNumCnt && temp < 2) {
                frequentNum = i;
                temp++;
            }
            sum += counting[i];
            counting[i] = sum;
        }

        for (int i = N - 1; i > -1; i--) {
            int index = counting[inputs[i]] - 1;
            sorted[index] = inputs[i] - 4000;
            counting[inputs[i]]--;
        }

        System.out.println((int) Math.round(sumValue / N));
        System.out.println(sorted[N / 2]);
        System.out.println(frequentNum - 4000);
        System.out.println(sorted[N - 1] - sorted[0]);

    }
}
