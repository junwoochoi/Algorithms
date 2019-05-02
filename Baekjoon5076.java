package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/5076
 * 백준 5076 웹페이지
 */
public class Baekjoon5076 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        while (!"#".equals(input)) {

            solution(input);

            input = br.readLine();
        }
    }

    private static void solution(String input) {
        Stack<String> stack = new Stack<>();

        int index = 0;
        while(index<input.length()){
            char c = input.charAt(index);

            if(c == '<'){
                StringBuilder sb = new StringBuilder();
                int temp = 1;
                boolean isClosingTag = false;
                if(input.charAt(index+temp) == '/'){
                    isClosingTag = true;
                    temp++;
                }
                while(true){
                    if(input.charAt(index+temp) != '>'){
                        sb.append(input.charAt(index+temp));
                        temp++;
                    } else {
                        break;
                    }
                }
                index+=temp;
                //자기 혼자 열고 닫는 태그
                if(sb.toString().charAt(sb.length()-1) == '/'){
                    continue;
                }
                //닫는 태그
                if(isClosingTag){
                    if(stack.isEmpty()){
                        System.out.println("illegal");
                        return;
                    } else if(!stack.pop().equals(sb.toString())){
                        System.out.println("illegal");
                        return;
                    }
                } else {

                    stack.push(sb.toString().split(" ")[0]);
                }

            }
            index++;
        }
        if(stack.isEmpty()){
            System.out.println("legal");
        } else {
            System.out.println("illegal");
        }
    }
}
