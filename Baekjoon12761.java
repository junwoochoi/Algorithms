package algo.Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/12761
 * 백준 12761번 돌다리
 */
public class Baekjoon12761 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int A, B, N, M;
    static int[] visited = new int[100001];
    static int[] dx ;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        Arrays.fill(visited, Integer.MAX_VALUE);
        dx = new int[]{A, B, 1};


        solution();
    }

    private static void solution() {
        Queue<Integer> queue = new LinkedList<>();

        visited[N] = 0;
        queue.add(N);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if(current==M){
                System.out.println(visited[M]);
                return;
            }

            int nextPosition = 0;

            for (int i = 0; i < 2; i++) {
                nextPosition = current*dx[i];
                if( nextPosition < 0 || nextPosition>100000 || visited[nextPosition]<=visited[current]+1) continue;
                visited[nextPosition] = visited[current]+1;
                queue.add(nextPosition);
            }

            for (int i = 0; i < 3; i++) {
                nextPosition = current + dx[i];
                if( nextPosition < 0 || nextPosition>100000 || visited[nextPosition]<=visited[current]+1) continue;
                visited[nextPosition] = visited[current]+1;
                queue.add(nextPosition);
            }

            for (int i = 0; i < 3; i++) {
                nextPosition = current - dx[i];
                if( nextPosition < 0 || nextPosition>100000 || visited[nextPosition]<=visited[current]+1) continue;
                visited[nextPosition] = visited[current]+1;
                queue.add(nextPosition);
            }


        }

    }
}
