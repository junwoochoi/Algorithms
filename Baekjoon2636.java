package algo.Algorithms;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2636
 * 백준 2636번 치즈 DFS, BFS 연습
 */
public class Baekjoon2636 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int count = 0;
    static Queue<Node> searchQueue = new LinkedList<>();
    static Queue<Node> edgeQueue = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[][] plate = new int[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];

        for (int i = 0; i < plate.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j = 0;
            while (st.hasMoreTokens()) {
                plate[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }

        while (!isAllGone(plate)){
            bfs(plate);
        }
        System.out.println(count);
        System.out.println(searchQueue.size());
    }

    private static boolean isAllGone(int[][] plate) {
        for(int[] arr: plate){
            for(int n : arr){
                if(n==1) return false;
            }
        }
        return true;
    }

    private static void bfs(int[][] plate) {
        boolean[][] visited = new boolean[101][101];
        searchQueue.offer(new Node(0,0));
        visited[0][0] = true;
        while (!searchQueue.isEmpty()){
            Node current = searchQueue.poll();

            for(int i=0; i<4; i++){
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if(nextX<0 || nextY<0 || nextX>=plate.length || nextY>=plate[0].length) continue;

                if(plate[nextX][nextY] == 0 && !visited[nextX][nextY]){
                    visited[nextX][nextY] = true;
                    searchQueue.offer(new Node(nextX, nextY));
                }
                if(plate[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                    edgeQueue.offer(new Node(nextX, nextY));
                    visited[nextX][nextY] = true;
                }

            }
        }


        while(!edgeQueue.isEmpty()){
            Node current = edgeQueue.poll();

            plate[current.x][current.y] = 0;
            searchQueue.offer(new Node(current.x, current.y));

        }

        if(!searchQueue.isEmpty()){
            count++;
        }


    }


    private static class Node {
        public int x;
        public int y;

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


