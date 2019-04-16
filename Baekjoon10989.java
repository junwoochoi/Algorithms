package Algorithms;

import java.io.*;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/10989
 * 백준 수 정렬하기 카운팅정렬, 기수 정렬
 */
public class Baekjoon10989 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        int[] counting = new int[10001];


        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
            counting[numbers[i]]++;
        }

        int sum = 0;
        for (int j = 0; j < counting.length; j++) {
            if (counting[j] == 0) continue;
            sum += counting[j];
            counting[j] = sum;
        }


        int[] sorted = new int[N];

        for (int i = N - 1; i >= 0; i--) {
            int index = counting[numbers[i]] - 1;
            counting[numbers[i]]--;
            sorted[index] = numbers[i];
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int n : sorted) {
            bw.write(n+"\n");
        }

        bw.flush();


    }
}
