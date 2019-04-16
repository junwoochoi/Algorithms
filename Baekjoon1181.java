package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1181
 * 백준 1181번 단어 정렬
 */
public class Baekjoon1181 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static String[] inputs;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            if (!list.contains(input))
                list.add(input);
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length())
                    return o1.compareTo(o2);
                return o1.length() - o2.length();
            }
        });


        for (String str : list) {
            System.out.println(str);
        }
    }
}
