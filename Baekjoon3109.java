package algo.Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/3109
 * 백준 3109 빵집
 */
public class Baekjoon3109 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int R, C;
    static char[][] map;
    static List<Node> passed = new ArrayList<>();
    static boolean visited[][];
    static int count = 0;
    private static boolean flag = false;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        visited = new boolean[R][C];


        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine().trim();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            flag = false;
            Node node = new Node(i, 0);
            dfs(node);
        }

        System.out.println(count);

    }

    private static void dfs(Node node) {

        if (node.y == C - 1) {
            count++;
            flag = true;
            return;
        }


        for (int i = -1; i < 2; i++) {
            int nX = node.x + i;
            int nY = node.y + 1;

            if (nX < 0 || nX >= R || nY >= C) continue;

            if (map[nX][nY] == 'x' || visited[nX][nY]) continue;

            visited[nX][nY] = true;

            Node nextNode = new Node(nX, nY);

            dfs(nextNode);

            if(flag) break;
        }

    }



static class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Node{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
}
