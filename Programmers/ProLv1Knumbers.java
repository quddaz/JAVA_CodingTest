import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> al = new ArrayList<>();
        int[] answer = new int[commands.length];
        
        for (int i = 0; i < commands.length; i++) {
            al.clear(); // ArrayList를 비우기 위해 clear() 사용

            for (int j = commands[i][0] - 1; j < commands[i][1]; j++) {
                al.add(array[j]);
            }

            Collections.sort(al); // 정렬을 위해 Collections.sort() 사용
            answer[i] = al.get(commands[i][2] - 1);
        }

        return answer;
    }
}