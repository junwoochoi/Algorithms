package algo.Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1764
 * 백준 1764번 문제
 */
public class Baekjoon1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N + M; i++) {
            String name = br.readLine();
            if (map.containsKey(name)) {
                map.put(name, 2);
                continue;
            }
            map.put(name, 1);
        }

        List<String> list = new ArrayList<>() ;
        for (String name : map.keySet()) {
            if(map.get(name) == 2){
                list.add(name);
            }
        }
        Collections.sort(list);

        System.out.println(list.size());
        for(String name : list){
            System.out.println(name);
        }
    }
}
