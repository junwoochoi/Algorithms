package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/**
 * https://www.acmicpc.net/problem/6359
 * 백준 6359번 문제  만취한 상범
 * DP문제
 */
public class DrunkenSangBeom {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dp= new int[101];
    public static void main(String[] args) throws IOException {
        int test = Integer.parseInt(br.readLine());

        dp[1] = 1;
        dp[2] = 1;
        for(int i = 2; i<=100; i++){
            int count = 0;
            for(int x = 1; x<=i; x++){
                if(i % x == 0){
                    count++;
                }
            }
            dp[i] = (count%2 == 1) ? dp[i-1]+1 : dp[i-1];
        }

        while(test-- > 0){
            int roomCount = Integer.parseInt(br.readLine());

            System.out.println(dp[roomCount]);
        }
    }
}
