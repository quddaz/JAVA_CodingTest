import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        PriorityQueue<Integer> honor = new PriorityQueue<>();
        int[] answer = new int[score.length];

        for (int i = 0; i < score.length; i++) {
            if (i < k) {
                honor.add(score[i]);
            } else {
                if (honor.peek() < score[i]) {
                    honor.poll();
                    honor.add(score[i]);
                }
            }
            answer[i] = honor.peek(); //큐의 맨앞을 가져옴
        }

        return answer;
    }
}