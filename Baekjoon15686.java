package algo.Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 * https://www.acmicpc.net/problem/15686
 * 백준 15686번 치킨배달
 */
public class Baekjoon15686 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] map;
    static int N, M;
    static int distance = Integer.MAX_VALUE;
    static boolean[] chickenFlagArr;
    static List<Node> chickenList = new ArrayList<>();
    static List<Node> houseList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    chickenList.add(new Node(i, j));
                }
                if (map[i][j] == 1) {
                    houseList.add(new Node(i, j));
                }
            }
        }

        chickenFlagArr = new boolean[chickenList.size()+1];


        dfs(0, 0);


        System.out.println(distance);


    }

    private static void dfs(int index, int currentCount) {
        if(index>chickenList.size()) return;

        if(currentCount == M) {
            calculateChickenDistance();
            return;
        }

            chickenFlagArr[index] = true;

            dfs(index+1, currentCount+1);

            chickenFlagArr[index] = false;

            dfs(index+1, currentCount);
    }

    private static void calculateChickenDistance() {
        int wholeDistance = 0;
        for (int i = 0; i < houseList.size(); i++) {
            Node currentHouse = houseList.get(i);
            int minDistance = Integer.MAX_VALUE;
            for (int j = 0; j < chickenList.size(); j++) {
                if(!chickenFlagArr[j]) continue;

                Node currentChickenShop = chickenList.get(j);

                int currentDistance = Math.abs(currentChickenShop.x-currentHouse.x)+Math.abs(currentChickenShop.y-currentHouse.y);
                minDistance = Math.min(minDistance, currentDistance);

            }
            wholeDistance+=minDistance;
        }

        distance = Math.min(distance, wholeDistance);
    }


    public static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
