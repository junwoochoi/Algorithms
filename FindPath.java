package algo.Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11403
 * 백준 11403번 문제 경로찾기
 */
public class FindPath {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int graph[][] = new int[num][num];


        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int j = 0;
            while (st.hasMoreTokens()) {
                graph[i][j] = Integer.parseInt(st.nextToken());

                j++;
            }
        }
        int[][] answer = new int[num][num];
        for (int x = 0; x < num; x++) {
            boolean[] visted = new boolean[num];
            checkPath(x, graph, visted);
            for(int y=0; y<num; y++){
                answer[x][y] = visted[y] ? 1 : 0;
            }
        }

        System.out.println(Arrays.deepToString(answer));

    }

    private static void checkPath(int x, int[][] graph, boolean[] visted) {
        int i = 0;
        for (int num : graph[x]) {
            if (num == 1 && !visted[i]) {
                visted[i] = true;
                checkPath(i, graph, visted);
            }
            i++;
        }

    }


}
