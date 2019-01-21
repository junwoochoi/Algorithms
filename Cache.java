package algo.Algorithms;

import algo.Packing;

import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/17680?language=java
 * 카카오 2017 기출 ( 캐시 ) 난이도 하
 */
public class Cache {

    public static void main(String[] args) {
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        System.out.println(solution(cacheSize, cities));
    }

    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        Queue<String> queue = new LinkedList<>();


        for (String city : cities) {
            queue.add(city.toLowerCase());
        }

        Queue<String> cache = new LinkedList<>();

        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (cache.contains(current)) {
                answer += 1;
                cache.remove(current);
            } else {
                answer += 5;
                if (cache.size() >= cacheSize) {
                    cache.poll();
                }
            }
            cache.add(current);
        }


        return answer;
    }
}
