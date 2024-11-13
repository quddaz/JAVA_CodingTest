import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        Arrays.sort(lost);


        ArrayList<Integer> reserveList = new ArrayList<>();
        for (int num : reserve) {
            reserveList.add(num);
        }
        for(int i = 0; i < lost.length;i++){
            if (reserveList.contains(lost[i])) {
                reserveList.remove(Integer.valueOf(lost[i]));
                answer++;
            }
        }
        for (int i = 0; i < lost.length; i++) {
            if (reserveList.contains(lost[i] - 1)) {
                reserveList.remove(Integer.valueOf(lost[i] - 1));
                answer++;
            } else if (reserveList.contains(lost[i] + 1)) {
                reserveList.remove(Integer.valueOf(lost[i] + 1));
                answer++;
            }
        }

        return answer;
    }
}