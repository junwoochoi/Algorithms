package algo.Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1987
 * 백준 1987 알파벳
 */
public class Baekjoon1987 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int R, C;
    static char[][] input;
    static int max = -1;
    static List<Character> passed = new ArrayList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        input = new char[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                input[i][j] = str.charAt(j);
            }
        }


        passed.add(input[0][0]);

        dfs(new Node(0, 0));

        System.out.println(max);
    }

    private static void dfs(Node current) {

        int x = current.x;
        int y = current.y;


        max = Math.max(passed.size(), max);
        for (int i = 0; i < 4; i++) {
            int dX = dx[i] + x;
            int dY = dy[i] + y;

            if(dX < 0 || dY < 0 || dX >= R || dY >= C) continue;

            if(passed.contains(input[dX][dY])) continue;


            passed.add(input[dX][dY]);

            dfs(new Node(dX, dY));

            passed.remove(Character.valueOf(input[dX][dY]));
        }

       return;
    }


    private static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
