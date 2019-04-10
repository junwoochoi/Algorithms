package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1051
 * 백준 1051번 정사각
 */
public class Baekjoon1051 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static Integer N, M;
    private static int[][] map;
    private static int answer = 1;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                solution(i, j);
            }
        }

        System.out.println(answer);

    }

    private static void solution(int x, int y) {
        for (int i = y+1; i < M; i++) {
            int dist = i - y;
            if (map[x][i] != map[x][y]) continue;
            if( x+dist >= N || y+dist >= M) continue;
            if( (dist+1) * (dist+1) <=  answer) continue;


            if(map[x][y] == map[x+dist][y] && map[x][y] == map[x+dist][y+dist]){
                answer = (dist+1) * (dist+1);
            }
        }
    }
}
