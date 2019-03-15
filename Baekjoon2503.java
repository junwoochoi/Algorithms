package algo.Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2503
 * 백준 2503번 숫자야구
 */
public class Baekjoon2503 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Guess> guessList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int M = Integer.parseInt(br.readLine());

        while (M-- > 0) {
            check();
        }
        int count= 0;
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    if(i==j || j==k || i ==k ) continue;
                    if(verify(i +String.valueOf(j)+ k)){
                        count++;
                    }
                }
            }
        }

        System.out.println(count);

    }

    private static boolean verify(String s) {
        for(Guess guess : guessList){
            String compare = guess.guess;
            int ball = 0;
            int strike = 0;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(compare.charAt(i) == s.charAt(j)){
                        if(i==j) strike++;
                        else ball++;
                    }
                }
            }

            if(ball != guess.ball || strike != guess.strike) return false;
        }

        return true;
    }

    private static void check() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        String guess = st.nextToken();
        int strike = Integer.parseInt(st.nextToken());
        int ball = Integer.parseInt(st.nextToken());

        guessList.add(new Guess(guess, strike, ball));
    }

    private static class Guess {
        String guess;
        int strike, ball;

        public Guess(String guess, int strike, int ball) {
            this.guess = guess;
            this.ball = ball;
            this.strike = strike;
        }
    }
}
