package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.acmicpc.net/problem/1992
 * 백준 1992 쿼드트리
 */
public class Baekjoon1992 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] map;
    private static boolean[][] visited;
    private static int N = -1;
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j]=input.charAt(j)-'0';
            }
        }

        quadTree(N, 0, 0);

        System.out.println(answer.toString());
    }

    private static void quadTree(int n, int y, int x) {
        if(n==1){
            answer.append(map[y][x]);
            return;
        }

        boolean isAllZero =true;
        boolean isAllOne =true;

        for (int i = y; i < y+n; i++) {
            for (int j = x; j < x+n; j++) {
                if(map[i][j] == 1){
                    isAllZero = false;
                } else if(map[i][j] == 0){
                    isAllOne = false;
                }
            }
        }

        if(isAllOne){
            answer.append(1);
        } else if(isAllZero){
            answer.append(0);
        } else {
            answer.append("(");

            quadTree(n / 2, y, x);
            quadTree(n / 2, y, x + n / 2);
            quadTree(n / 2, y + n / 2, x);
            quadTree(n / 2, y + n / 2, x + n / 2);

            answer.append(")");
        }
    }


}
