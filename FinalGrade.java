package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/3665
 * 최종순위 (백준) 위상정렬 연습
 */
public class FinalGrade {
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        // 테스트 케이스
        int caseCount = Integer.parseInt(br.readLine().trim());
        while (caseCount-- > 0) {
            getGrade();

        }
    }

    private static void getGrade() throws IOException {
        int teamCount = Integer.parseInt(br.readLine().trim());
        List<Integer> lastYear = new ArrayList<>();
        Map<Integer, List<Integer>> nodeMap = new HashMap<>();
        Map<Integer, Integer> indegreeMap = new HashMap<>();
        HashSet<Integer> influenced = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
        while (st.hasMoreTokens()) {
            int e = Integer.parseInt(st.nextToken());
            lastYear.add(e);
            nodeMap.put(e, new ArrayList<>());
            indegreeMap.put(e, 0);
        }
        int changeCount = Integer.parseInt(br.readLine());
        while (changeCount-- > 0) {
            String[] changed = br.readLine().split(" ");
            int from = Integer.parseInt(changed[0]);
            int to = Integer.parseInt(changed[1]);


            if (lastYear.indexOf(from) < lastYear.indexOf(to)) {
                System.out.println("IMPOSSIBLE");
                return;
            }

            //바뀐값들 저장
            influenced.add(to);
            influenced.add(from);

            //연결된 차수 증가
            int indegree = indegreeMap.get(to);
            indegreeMap.put(to, ++indegree);

            //연결된 간선 추가
            List<Integer> tempList = nodeMap.get(from);
            tempList.add(to);
            nodeMap.put(from, tempList);

        }


        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return lastYear.indexOf(o1) - lastYear.indexOf(o2);
            }
        });
        Queue<Integer> answerQueue = new LinkedList<>();
        for (Integer key : indegreeMap.keySet()) {
            if (indegreeMap.get(key) == 0 && influenced.contains(key)) {
                queue.add(key);
            }
        }

        while (!queue.isEmpty()) {

            int current = queue.poll();
            answerQueue.add(current);

            List<Integer> targets = nodeMap.get(current);
            for (int target : targets) {
                int indegree = indegreeMap.get(target) - 1;
                indegreeMap.put(target, indegree);
                if (indegree == 0) {
                    queue.add(target);
                }
            }
            nodeMap.put(current, new ArrayList<>());
        }


        List<Integer> thisYearGrade = new ArrayList<>();
        int lastIndex = 0;
        for (int last : lastYear) {
            if (!influenced.contains(last)) {
                thisYearGrade.add(lastIndex, last);
            } else {
                int answer = answerQueue.poll();
                thisYearGrade.add(answer);
            }
            lastIndex++;
        }

        StringBuffer sb = new StringBuffer();
        for (Integer e : thisYearGrade) {
            sb.append(e);
            sb.append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
