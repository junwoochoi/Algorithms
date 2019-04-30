package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1904
 * 백준 1904 01타일
 */
public class Baekjoon1904 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        //피보나치 수열로 문제 풀이가능
        int N = Integer.parseInt(br.readLine());
        long[] fibonacci = new long[N+1];
        fibonacci[0] = 1;
        fibonacci[1] = 1;
        for (int i = 2; i <= N; i++) {
            fibonacci[i] = (fibonacci[i-1] + fibonacci[i-2])%15746;
        }

        System.out.println(fibonacci[N]);
    }
}
