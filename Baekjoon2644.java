package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2644
 * 백준 2644번 촌수계산
 */
public class Baekjoon2644 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int numberOfPeople = Integer.parseInt(br.readLine());

        int[][] people = new int[numberOfPeople + 1][numberOfPeople + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int lines = Integer.parseInt(br.readLine());

        while (lines-- > 0) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            people[parent][child] = 1;
            people[child][parent] = 1;
        }

        int[] visited = new int[people.length];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = 1;
        queue.offer(start);


        while (!queue.isEmpty()) {

            int current = queue.poll();

            int i = 0;
            for (int num : people[current]) {
                if (num == 1 && visited[i] == 0) {
                    visited[i] = visited[current] + 1;
                    queue.offer(i);
                }
                i++;
            }
        }

        System.out.println(visited[end] - 1);

    }
}
