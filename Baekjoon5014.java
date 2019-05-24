package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/5014
 * 백준 5014번 스타트링크
 */
public class Baekjoon5014 {
    private static final String USE_STAIRS = "use the stairs";
    private static int[] building;
    private static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        building = new int[F + 1];
        visited = new int[F + 1];


        solution(F, S, G, U, D);

    }

    private static void solution(int maxFloor, int start, int company, int up, int down) {
        Queue<Integer> queue = new LinkedList<>();


        visited[start] = 0;
        queue.add(start);

        while (!queue.isEmpty()) {
            int curentFloor = queue.poll();

            if(curentFloor == company){
                break;
            }

            int upFloor = curentFloor+up;
            int downFloor = curentFloor-down;

            if(upFloor<=maxFloor){
                if(visited[upFloor] == 0){
                    visited[upFloor] = visited[curentFloor]+1;
                    queue.add(upFloor);
                }
            }

            if(downFloor>0){
                if(visited[downFloor] == 0){
                    visited[downFloor] = visited[curentFloor]+1;
                    queue.add(downFloor);
                }
            }
        }

        if(visited[company] == 0){
            System.out.println(USE_STAIRS);
            return;
        }

        System.out.println(visited[company]);
    }
}
