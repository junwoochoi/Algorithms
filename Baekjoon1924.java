package Algorithms;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/1924
 * 백준 1924 2007년
 */
public class Baekjoon1924 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };

        Calendar cal = Calendar.getInstance();
        cal.set(2007, x-1, y);




        System.out.println(days[cal.get(Calendar.DAY_OF_WEEK)-1]);
    }
}
