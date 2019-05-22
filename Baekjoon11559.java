package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/11559
 * 백준 11559 뿌요뿌요
 */
public class Baekjoon11559 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static char[][] map = new char[12][6];
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    private static Queue<Character> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 12; i++) {
            String input = br.readLine().trim();
            for (int j = 0; j < 6; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        boolean isCombo = true;
        int count = -1;
        while(isCombo){
            isCombo = dayPass();
//
//            for (int i = 0; i < 12; i++) {
//                System.out.println(Arrays.toString(map[i]));
//            }
//                System.out.println("------------------------\n");
            count++;
        }

        System.out.println(count);
    }

    private static boolean dayPass() {
        boolean[][] visited = new boolean[12][6];
        boolean isChanged = false;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (map[i][j] != '.' && !visited[i][j]) {
                    ArrayList<Node> nodes = new ArrayList<>();
                    nodes.add(new Node(i, j));
                    dfs(i, j, nodes, visited);
                    if (nodes.size() > 3) {
                        isChanged = true;
                        for (Node node : nodes) {
                            map[node.x][node.y] = '.';
                        }
                    }
                }
            }
        }

        if(isChanged){
            gravity();
        }


        return isChanged;
    }

    private static void gravity() {
        for (int i = 0; i < 6; i++) {
            Queue<Character> queue = new LinkedList<>();

            for (int j = 11; j > -1 ; j--) {
                if(map[j][i] != '.') queue.add(map[j][i]);

                map[j][i] = '.';
            }

            int temp = 11;
            while(!queue.isEmpty()){
                map[temp][i] = queue.poll();
                temp--;
            }
        }
    }

    private static void dfs(int x, int y, ArrayList<Node> nodes, boolean[][] visited) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= 12 || nextY >= 6) continue;
            if (visited[nextX][nextY]) continue;

            if (map[x][y] == map[nextX][nextY]) {
                nodes.add(new Node(nextX, nextY));
                dfs(nextX, nextY, nodes, visited);
            }
        }

    }

    private static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
