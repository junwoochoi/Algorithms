package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 백준 9375 패션왕 신혜빈
 * 2
 * 3
 * hat headgear
 * sunglasses eyewear
 * turban headgear
 * 3
 * mask face
 * sunglasses face
 * makeup face
 */
public class Baekjoon9375 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int num = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < num; j++) {

                String[] input = br.readLine().split(" ");

                if (map.containsKey(input[1])) {
                    map.put(input[1], map.get(input[1])+1);
                } else {
                    map.put(input[1], 1);
                }

            }
            solution(map);
        }
    }

    private static void solution(Map<String, Integer> map) {
        int kind = map.keySet().size();
        int answer = 1;

        for (String key : map.keySet()) {
            int count = map.get(key);

            answer *= count+1;
        }

            answer--;

        System.out.println(answer);

    }
}
