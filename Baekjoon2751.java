package Algorithms;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/2750
 * 백준 정렬해보기 2751번
 */
public class Baekjoon2751 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        mergeSort(numbers, 0, numbers.length - 1);
        for (int num : numbers) {
            System.out.println(num);
        }
    }

    private static void mergeSort(int[] numbers, int start, int end) {
        if(start>=end) return;
        int middle = (start + end) / 2;
        mergeSort(numbers, start, middle);
        mergeSort(numbers, middle + 1, end);
        merge(numbers, start, middle, middle + 1, end);
    }


    private static void merge(int[] original, int leftStart, int leftEnd, int rightStart, int rightEnd) {
        int i = leftStart;
        int j = rightStart;
        int index = 0;
        int[] sorted = new int[rightEnd-leftStart+1];

        while (index < sorted.length) {
            if(i>leftEnd){
                sorted[index++] = original[j++];
                continue;
            }
            if(j>rightEnd){
                sorted[index++] = original[i++];
                continue;
            }
            if (original[i] > original[j]) {
                sorted[index] = original[j++];
            } else {
                sorted[index] = original[i++];
            }
            index++;
        }


        for (int k = leftStart; k <= rightEnd; k++) {
            original[k] = sorted[k-leftStart];
        }


    }


}
