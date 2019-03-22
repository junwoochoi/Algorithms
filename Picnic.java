package algo.Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://algospot.com/judge/problem/read/PICNIC
 * 알고스팟 피크닉 PICNIC
 */
public class Picnic {
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static int N = 0;
    static int M = 0;
    static int count = 0;
    static boolean[][] friends;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        int C = Integer.parseInt(br.readLine().trim());
        while(C-->0){
            count= 0;
            solution();
            System.out.println(count);
        }
    }

    private static void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        friends = new boolean[N][N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int person1 = Integer.parseInt(st.nextToken());
            int person2 = Integer.parseInt(st.nextToken());

            friends[person1][person2] = true;
            friends[person2][person1] = true;
        }

        dfs();
    }

    private static void dfs() {
        int person = findNotQueue();

        if(person<0){
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if(i == person) continue;
            if(friends[person][i] && !visited[i]){
                visited[person] = true;
                visited[i] = true;
                dfs();
                visited[person] = false;
                visited[i] = false;
            }
        }
    }

    private static int findNotQueue() {
        for (int i = 0; i < N; i++) {
            if(!visited[i]) return i;
        }
        return -1;
    }
}
