import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> al = new ArrayList<>();
        int[] answer = new int[commands.length];
        
        for (int i = 0; i < commands.length; i++) {
            al.clear(); 
            // 1. 자르기 
            for (int j = commands[i][0] - 1; j < commands[i][1]; j++) {
                al.add(array[j]);
            }
            // 2. 정렬
            Collections.sort(al); 
            // 3. 숫자 정하기
            answer[i] = al.get(commands[i][2] - 1);
        }

        return answer;
    }
}
/*
* 1. 자르기
* 2. 정렬
* 3. 숫자 정하기 
*/