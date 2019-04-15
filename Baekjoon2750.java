package Algorithms;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/2750
 * 백준 정렬해보기 2750번
 */
public class Baekjoon2750 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        boolean[] visited = new boolean[N];
        numbers = quickSort(numbers, 0, N - 1, visited);

//        numbers = selectionSort(N, numbers);


//        insertionSort(N, numbers);
//        int check = N;
//        bubbleSort(N, numbers, check);
//        Arrays.sort(numbers);

        for (int num : numbers) {
            System.out.println(num);
        }
    }

    private static int[] quickSort(int[] numbers, int start, int end, boolean[] visited) {

        int pivot = start + (end - start) / 2;


        for (int i = start; i <= end; i++) {
            if (numbers[pivot] < numbers[i] && i < pivot) {
                int temp = numbers[i];
                for (int j = i; j < end; j++) {
                    numbers[j] = numbers[j + 1];
                }
                numbers[end] = temp;
                pivot--;
                i--;
            } else if (numbers[pivot] > numbers[i] && i > pivot) {
                int temp = numbers[i];
                for (int j = i - 1; j >= start; j--) {
                    numbers[j + 1] = numbers[j];
                }
                numbers[start] = temp;
                pivot++;
                i++;
            }
        }


        if (start != pivot - 1 && start != pivot) {
            quickSort(numbers, start, pivot - 1, visited);
        }
        if (end != pivot + 1 && end != pivot+2) {
            quickSort(numbers, pivot + 1, end, visited);
        }

        return numbers;
    }


    private static int[] selectionSort(int n, int[] numbers) {

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (numbers[i] > numbers[j]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[i];
                    numbers[i] = temp;
                }
            }
        }

        return numbers;
    }

    private static void insertionSort(int n, int[] numbers) {
        int sortedIndex = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= sortedIndex; j++) {
                if (numbers[j] > numbers[i]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
            sortedIndex++;
        }
    }

    private static void bubbleSort(int n, int[] numbers, int check) {
        while (check-- > 0) {

            for (int i = 0; i < n - 1; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = temp;
                }
            }
        }
    }
}
