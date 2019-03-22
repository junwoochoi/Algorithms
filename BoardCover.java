package algo.Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://algospot.com/judge/problem/read/BOARDCOVER
 * 알고스팟 BOARDCOVER  난이도 하(라는데 매우 어려움 나한텐..)
 */
public class BoardCover {
    public static int H = 0;
    public static int W = 0;
    public static int[][] map;
    public static int[][][] arr = {
            {{0, 0}, {1, 0}, {0, 1}},
            {{0, 0}, {1, 0}, {1, -1}},
            {{0, 0}, {1, 0}, {1, 1}},
            {{0, 0}, {0, 1}, {1, 1}}
    };
    public static int count = 0;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int C = Integer.parseInt(br.readLine().trim());
        while (C-- > 0) {
            count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            solution();
        }
    }

    private static void solution() throws IOException {
        map = new int[H][W];

        for (int i = 0; i < H; i++) {
            String str = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = str.charAt(j) == '#' ? 1 : 0;
            }
        }

        dfs();

        System.out.println(count);

    }

    private static void dfs() {
        Node node = findFirstWhiteBlock();
        if (node == null) {
            count++;
            return;
        }

        outerloop:
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                int nextX = node.x + arr[i][j][0];
                int nextY = node.y + arr[i][j][1];
                if (nextX < 0 || nextY < 0 || nextX >= H || nextY >= W) continue outerloop;
                if (map[nextX][nextY] == 1) continue outerloop;
            }
            set(node, arr[i], 1);
            dfs();

            set(node, arr[i], 0);
        }


    }

    private static void set(Node node, int[][] arr, int num) {
        for (int j = 0; j < 3; j++) {
            int nextX = node.x + arr[j][0];
            int nextY = node.y + arr[j][1];
            map[nextX][nextY] = num;
        }
    }


    private static Node findFirstWhiteBlock() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] == 0) return new Node(i, j);
            }
        }
        return null;
    }

    public static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}
