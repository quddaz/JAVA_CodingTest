import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Integer[] arr = new Integer[score.length];
        for(int i = 0; i < arr.length;i++)
            arr[i] = score[i];
        Arrays.sort(arr,Collections.reverseOrder());

        for(int i = m-1; i < score.length;i+=m){
            answer += arr[i]*m;
        }
        return answer;
    }
}

/*
사과의 최대 점수 k
한 상자에 들어가는 사과의 수 m
사과들의 점수 score 
1. 사과 배열에서 큰것부터 선택해서 점수 얻기 
2. 배열 계산을 통한 구현
*/