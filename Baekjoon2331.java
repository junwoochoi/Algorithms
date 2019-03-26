package algo.Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2331
 * 백준 2331 반복수열
 */
public class Baekjoon2331 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int A = 0;
    private static int P = 0;
    private static int[] numbers = new int[1000001];
    private static boolean[] cache = new boolean[1000001];
    private static int start = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        cache[A] = true;
        numbers[0] = A;

        for (int i = 0; i < numbers.length-2; i++) {
            int num = numbers[i];
            int sum = 0;
            while(num!=0){
                sum += Math.pow((num%10), P);
                num /= 10;
            }
            if(!cache[sum]){
                cache[sum] = true;
                numbers[i+1] = sum;
            } else {
                start = sum;
                break;
            }
        }

        int count = 0;
        for (int i = 0; i < numbers.length-1; i++) {
            if(numbers[i]==start) break;
            count++;
        }
        System.out.println(count);
    }



}
