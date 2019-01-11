package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11055
 * 백준 11055번 문제 가장 큰 증가 부분수열
 */
public class BiggestIncreaseNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        int[] numbers = new int[length];
        int[] dp = new int[length];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            dp[i] = numbers[i];
        }
        int max = numbers[0];

        for(int i=0; i<length; i++){
            for(int j = 0; j<i; j++){
                if(numbers[i]>numbers[j]){
                    dp[i] = Math.max(dp[i], dp[j] + numbers[i]);
                }
                max = Math.max(max, dp[i]);
            }
        }

        System.out.println(max);
    }

}
