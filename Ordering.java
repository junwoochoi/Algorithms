package algo;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://algospot.com/judge/problem/read/ORDERING
 * Ordering 알고스팟
 */
public class Ordering {


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int inputCount = Integer.parseInt(sc.nextLine().trim());


        while (inputCount-- > 0) {
            String[] countInput = sc.nextLine().trim().split(" ");
            int N = Integer.parseInt(countInput[0]);
            int M = Integer.parseInt(countInput[1]);
            Vector<Character> answer = new Vector<>();

            ArrayList<Integer>[] nodeArray = new ArrayList[N];
            int[] integrate = new int[N];

            for (int i = 0; i < N; i++) {
                nodeArray[i] = new ArrayList<>();
            }

            for (int j = 0; j < M; j++) {
                String fromTo = sc.nextLine().trim();
                int from = (int) fromTo.charAt(0) - 65;
                int to = (int) fromTo.charAt(1) - 65;

                nodeArray[from].add(to);
                integrate[to]++;
            }

            Queue<Integer> answerQueue = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1-o2;
                }
            });

            addNonRelatedToQueue(integrate, answerQueue);

            while(!answerQueue.isEmpty()){
//                System.out.println("AnswerQueue: >>>>>>>>>>> ");
//                System.out.println(Arrays.toString(answerQueue.toArray()));
//                System.out.println("#########################################");
                int current = answerQueue.poll();

                answer.add((char) (current+65));
                ArrayList<Integer> toList = nodeArray[current];
                for(int to: toList){
                    integrate[to]--;
                    if(integrate[to]==0){
                        answerQueue.add(to);
                    }
                }
                integrate[current] = -1;
                toList.removeAll(Collections.EMPTY_LIST);
            }

            StringBuffer sb = new StringBuffer();
            for(char c : answer){
                sb.append(c);
            }
            System.out.println(sb.toString());
        }
    }

    private static void addNonRelatedToQueue(int[] integrate, Queue<Integer> answerQueue) {
        int checkIndex = 0;
        for (int check: integrate){
            if(check==0){
                answerQueue.add(checkIndex);
            }
            checkIndex++;
        }
    }


}
