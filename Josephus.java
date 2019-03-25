package algo.Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://algospot.com/judge/problem/read/JOSEPHUS
 * 알고스팟 조세푸스 JOSEPHUS
 */
public class Josephus {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N = 0;
    static int K = 0;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        int C = Integer.parseInt(br.readLine());
        while (C-- > 0) {
            solution();
        }
    }

    private static void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        queue = new LinkedList<>();

        for (int i = 1; i < N + 1; i++) {
            queue.add(i);
        }

        kill();
    }

    private static void kill() {
        while (queue.size()!=2) {
            queue.poll();

            for (int i = 1; i < K; i++) {
                queue.add(queue.poll());
            }
        }

            int num1 = queue.poll();
            int num2 = queue.poll();

            if(num1> num2){
                System.out.println(num2 + " " + num1);
            } else {
                System.out.println(num1 + " " + num2);
            }

    }


}
