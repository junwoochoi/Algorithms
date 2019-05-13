package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1449
 * 백준 1449 수리공 항승
 */
public class Baekjoon1449 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int holeCount = Integer.parseInt(st.nextToken());
        int tapeLength = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] pipe = new int[holeCount];

        for (int i = 0; i < holeCount; i++) {
            pipe[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(pipe);

        int count = 1;
        int temp = pipe[0];
        for (int i = 1; i < holeCount; i++) {
            if(pipe[i] - temp > tapeLength - 1){
                temp = pipe[i];
                count++;
            }
        }


        System.out.println(count);

    }
}
