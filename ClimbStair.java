package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://www.acmicpc.net/problem/2579
 * 백준 2579번 문제 계단 오르기
 * DP문제
 */
public class ClimbStair {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int max = 0;
    static int[] stairs;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(br.readLine());
        stairs = new int[count+1];
        dp = new int[count+1];
        for (int i = 1; i <= count; i++) {
            stairs[i] = Integer.parseInt(br.readLine());

        }

        dp[0] =  stairs[0];
        dp[1] = Math.max(stairs[1]+ stairs[0], stairs[1]);
        dp[2] = Math.max(dp[1]+stairs[2], stairs[0]+stairs[2]);

        for(int j=3; j<=count; j++){
            dp[j] = Math.max(dp[j-2]+stairs[j], dp[j-3]+stairs[j-1]+stairs[j]);
        }

            System.out.println(dp[count]);

        }
}
