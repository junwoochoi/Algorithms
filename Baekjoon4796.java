package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/4796
 * 백준 4796 캠핑
 */
public class Baekjoon4796 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int caseNum = 1;
        while (!input.equals("0 0 0")) {
            StringTokenizer st = new StringTokenizer(input);
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            int answer = printAvailableDays(L, P, V);

            System.out.println("Case " + caseNum++ + ": " + answer);
            input = br.readLine();
        }
    }

    private static int printAvailableDays(int l, int p, int v) {
        if (v % p == 0) {
            return v / p * l;
        }


        int answer = v / p * l;
        v = v % p;

        if(v < l){
            return answer+v;
        }


        return answer + l;
    }
}
