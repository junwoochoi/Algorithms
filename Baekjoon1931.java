package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

/**
 * https://www.acmicpc.net/problem/1931
 * 백준 1931번 회의실배정
 */
public class Baekjoon1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        Conference[] conferences = new Conference[count];

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            conferences[i] = new Conference(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(conferences);
        int answer = 1;

        Conference selected = conferences[0];
        for (int i = 1; i < count; i++) {
            if (selected.end <= conferences[i].begin){
                answer++;
                selected = conferences[i];
            }
        }

        System.out.println(answer);

    }

    private static class Conference implements Comparable<Conference> {
        int begin, end;

        public Conference(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }

        @Override
        public int compareTo(Conference o) {
            if (o.end == this.end) {
                return this.begin - o.begin;
            } else {
                return this.end - o.end;
            }
        }


    }
}
