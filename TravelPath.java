package Algorithms;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43164
 * 프로그래머스 여행경로
 */
public class TravelPath {
    static List<String> visitedList = new ArrayList<>();
    static Map<String, List<String>> map = new HashMap<>();
    static List<String> result = new ArrayList<>();
    static Map<String, List<String>> visitedMap = new HashMap<>();
    static int lines = 0;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}})));
    }

    public static String[] solution(String[][] tickets) {
        String[] answer = {};

        lines = tickets.length;
        for (String[] strings : tickets) {
            if (!map.containsKey(strings[0])) {
                map.put(strings[0], new ArrayList<>());
            }
            if (!map.containsKey(strings[1])) {
                map.put(strings[1], new ArrayList<>());
            }
            List<String> list = map.get(strings[0]);
            list.add(strings[1]);
        }

        for (String[] strings : tickets) {
            visitedMap.put(strings[0], new ArrayList<>());
            List<String> list = map.get(strings[0]);
            Collections.sort(list);
            map.put(strings[0], list);
        }

        visitedList.add("ICN");
        dfs("ICN");

        return result.stream().toArray(String[]::new);
    }


    private static void dfs(String airport) {
        if (visitedList.size() == lines + 1) {
            if (isAvailable(visitedList)) {
                result.addAll(visitedList);
            }
            return;
        }

        if (result.size() > 0) return;


        List<String> canVisit = map.get(airport);

        if (canVisit != null) {
            for (String nextAirport : canVisit) {
                if (visitedMap.get(airport).contains(nextAirport)) continue;
                visitedMap.get(airport).add(nextAirport);
                visitedList.add(nextAirport);
                dfs(nextAirport);
                visitedList.remove(visitedList.size() - 1);
                visitedMap.get(airport).remove(nextAirport);
            }
        }

    }


    private static boolean isAvailable(List<String> visitedList) {
        Set<String> check = new HashSet<>();
        for (String str : visitedList) {
            check.add(str);
        }
        return check.size() == map.keySet().size();
    }
}
