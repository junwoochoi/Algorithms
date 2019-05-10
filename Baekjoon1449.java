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

        int[] pipe = new int[1001];
        boolean[] pipeCheck = new boolean[1001];

        for (int i = 0; i < holeCount; i++) {
            pipe[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(pipe, 0, holeCount);

        int count = 0;
        for (int i = 0; i < holeCount; i++) {
            if (!pipeCheck[i]) {
                count++;

                for (int j = pipe[i]; j < pipe[i] + tapeLength; j++) {
                    if(j > 1000) break;
                    pipeCheck[j] = true;
                }
            }
        }


        System.out.println(count);

    }
}
