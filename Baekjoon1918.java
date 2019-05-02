package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/1918
 * 백준 1918 후위표기
 */
public class Baekjoon1918 {
    private static Map<Character, Integer> precedenceMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine().trim();

        initPrecedenceMap();
        Stack<Character> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            //알파벳
            if(Character.isAlphabetic(c)){
                sb.append(c);
                continue;
            }
            // 여는 괄호일 때
            if(c =='('){
                stack.push(c);
                continue;
            }

            //닫는 괄호일 때
            if(c==')'){
                while(!stack.isEmpty() && stack.peek() != '('){
                    sb.append(stack.pop());
                }
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }
                continue;
            }

            //연산자 일때
            while(!stack.isEmpty() && ( precedenceMap.get(stack.peek()) >= precedenceMap.get(c))){
                sb.append(stack.pop());
            }
            stack.push(c);
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        System.out.println(sb.toString());
    }

    private static void initPrecedenceMap() {
        precedenceMap.put('+', 1);
        precedenceMap.put('-', 1);
        precedenceMap.put('*', 2);
        precedenceMap.put('/', 2);
        precedenceMap.put('(', -1);
        precedenceMap.put(')', -1);
    }


}
