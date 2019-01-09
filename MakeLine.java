package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/2252
 * 백준 2252 줄세우기
 * 위상 정렬
 */
public class MakeLine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int changeCount = sc.nextInt();
        int num[] = new int[length];
        int indegree[] = new int[length];
        List<Integer>[] vertexArray = new List[length];
        for (int i = 0; i < length; i++) {
            num[i] = i;
            vertexArray[i] = new ArrayList<>();
        }
        while (changeCount-- > 0) {
            int front = sc.nextInt()-1;
            int back = sc.nextInt()-1;

            indegree[back] += 1;
            vertexArray[front].add(back);
        }

        System.out.println(Arrays.toString(indegree));
        System.out.println(Arrays.toString(vertexArray));

        Queue<Integer> tempQueue = new LinkedList<>();
        Queue<Integer> answerQueue = new LinkedList<>();
        int index = 0;
        for (int indegreeValue : indegree) {
            if (indegreeValue == 0) {
                tempQueue.add(index);
            }
            index++;
        }
        while (!tempQueue.isEmpty()) {
            int current = tempQueue.poll();
            answerQueue.add(current);
            // 그 Vertex List를 가져와서 그 안에 값을 forEach로 받는다. 그걸 이제 차수에서 뺴준다.
            for (int to : vertexArray[current]) {
                indegree[to] -= 1;
                if(indegree[to]==0){
                    tempQueue.add(to);
                }
            }
            vertexArray[current].removeAll(Collections.EMPTY_LIST);
        }

        StringBuilder sb = new StringBuilder();
        for(int answer : answerQueue){
            sb.append(answer+1);
            sb.append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
