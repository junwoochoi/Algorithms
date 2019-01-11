package algo;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://algospot.com/judge/problem/read/PACKING#
 * 알고스팟 PACKING 문제
 */
public class Packing {

    static int maxSize;
    static int count;
    static int[][] cache = new int[1001][100];
    static Item[] items = new Item[100];
    static Vector<String> picked = new Vector<>();


    public static class Item  {
        private String name;
        private int weight;
        private int desperation;

        public Item(String name, int weight, int desperation) {
            this.name = name;
            this.weight = weight;
            this.desperation = desperation;
        }

        public String getName() {
            return name;
        }

        public int getWeight() {
            return weight;
        }

        public int getDesperation() {
            return desperation;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "name='" + name + '\'' +
                    ", weight=" + weight +
                    ", desperation=" + desperation +
                    '}';
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {

            packing(br);
        }
    }

    private static void packing(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        count = Integer.parseInt(st.nextToken());
        maxSize = Integer.parseInt(st.nextToken());
        for(int j=0; j<1001; j++){
            Arrays.fill(cache[j], -1);
        }
        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            Item item = new Item(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            items[i]=item;
        }

        int answer = whatToPack( maxSize, 0 );

        System.out.println(answer);


    }

    private static int whatToPack(int rest, int itemIndex) {

        if(itemIndex == count){
            return 0;
        }
        if(cache[rest][itemIndex] != -1 ){
            return cache[rest][itemIndex];
        }
        cache[rest][itemIndex] = whatToPack(maxSize, itemIndex+1);
        if(rest >= items[itemIndex].getWeight()){
            cache[rest][itemIndex] = Math.max(cache[rest][itemIndex], whatToPack(rest - items[itemIndex].getWeight(), itemIndex+1) + items[itemIndex].getDesperation());
        }
            return cache[rest][itemIndex];
    }


}
