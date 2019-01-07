package algo;

import java.util.Scanner;
import java.util.Stack;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42585?language=java
 * 쇠막대기
 */
public class IronStick {
    public static int solution(String arrangement) {
        Stack<String> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < arrangement.length(); i++) {
            String s = arrangement.substring(i, i + 1);
            String laiser = i+2<= arrangement.length() ? arrangement.substring(i, i+2) : "";



            if(laiser.equals("()")){
                count+=stack.size();
                i++;
            } else if(s.equals("(")){
                count++;
                stack.push(s);
            } else if(s.equals(")")){
                if(!stack.isEmpty())
                    stack.pop();
            }

        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String arrangement = sc.nextLine();
        sc.close();

        System.out.println(solution(arrangement));


    }


}
