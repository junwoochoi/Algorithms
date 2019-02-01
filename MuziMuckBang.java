package algo.Algorithms;

import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42891?language=java
 * 2018 카카오 블라인드 테스트
 * 무지의 먹방라이브
 */
public class MuziMuckBang {

    public static void main(String[] args) {
        MuziMuckBang muziMuckBang = new MuziMuckBang();
        int[] foodTimes = {3, 5, 1, 5, 5, 3};
        int solution = muziMuckBang.solution(foodTimes, 20);
        System.out.println(solution);
    }


    public static class Food {
        private int foodNum;
        private int remainTime;

        public int getFoodNum() {
            return foodNum;
        }

        public void setFoodNum(int foodNum) {
            this.foodNum = foodNum;
        }

        public int getRemainTime() {
            return remainTime;
        }

        public void setRemainTime(int remainTime) {
            this.remainTime = remainTime;
        }

        public Food(int foodNum, int remainTime) {
            this.foodNum = foodNum;
            this.remainTime = remainTime;
        }

        @Override
        public String toString() {
            return "Food{" +
                    "foodNum=" + foodNum +
                    ", remainTime=" + remainTime +
                    '}';
        }
    }

    public int solution(int[] food_times, long k) {
        int answer = 0;

        LinkedList<Food> checkQueue = new LinkedList<>();
        int index = 1;
        for (int remainTime : food_times) {
            Food food = new Food(index, remainTime);
            checkQueue.add(food);
            index++;
        }
        int n = food_times.length;
        checkQueue.sort(new Comparator<Food>() {
            @Override
            public int compare(Food o1, Food o2) {
                return Integer.compare(o1.getRemainTime(), o2.getRemainTime());
            }
        });

        int prevTime = 0;
        int i = 0;
        for(Food food : checkQueue){
            int diff = food.getRemainTime() - prevTime;
            if(diff != 0){
                long spend = diff*n;
                if(spend<=k){
                    k -= spend;
                    prevTime = food.getRemainTime();
                } else {
                    k %= n;
                    checkQueue.subList(i, food_times.length).sort(new Comparator<Food>() {
                        @Override
                        public int compare(Food o1, Food o2) {
                            return Integer.compare(o1.getFoodNum(), o2.getFoodNum());
                        }
                    });
                    return checkQueue.get(i+(int)k).getFoodNum();
                }
            }
            i++;
            n--;
        }
        return -1;
    }
}
