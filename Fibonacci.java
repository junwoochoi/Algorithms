package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1003
 * 백준 1003번 문제 피보나치
 */
public class Fibonacci {
    static int[] dpZero = new int[41];
    static int[] dpOne = new int[41];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        dpZero[0] = 1;
        dpOne[0] = 0;
        dpZero[1] = 0;
        dpOne[1] = 1;

        for(int i=2; i<41; i++){
            dpZero[i] = dpZero[i-1]+dpZero[i-2];
            dpOne[i] = dpOne[i-1]+dpOne[i-2];
        }

        while(test-- >0){
            int num = Integer.parseInt(br.readLine());
            System.out.println(dpZero[num] +" "+ dpOne[num]);
        }

    }
}
