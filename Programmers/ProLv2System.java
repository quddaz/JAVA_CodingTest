import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets,(o1,o2)-> {return o1[1]-o2[1]; });
        int answer = 0;
        int end = Integer.MIN_VALUE;

        for (int[] target : targets) {
            if (end <= target[0]) {
                end = target[1];
                answer++;
            }
        }

        return answer;
    }
}
/*
* 최소한의 미사일만 쓰는 그리디 알고리즘 문제
*/