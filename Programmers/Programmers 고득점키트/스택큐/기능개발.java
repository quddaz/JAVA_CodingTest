import java.util.*;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int n = progresses.length;
        int[] days = new int[n];
        
        for(int i = 0; i < progresses.length; i++) {
            int remainProgresses = 100 - progresses[i];
            if(remainProgresses % speeds[i] > 0) {
                days[i] = remainProgresses / speeds[i] + 1;
            }
            else {
                days[i] = remainProgresses / speeds[i];
            }
        }
        
        List<Integer> answer = new ArrayList<>();
        
        int maxDays = days[0];
        int count = 1;
        
        for (int i = 1; i < n; i++) {
            if (days[i] <= maxDays) {
                count++;
            } else {
                answer.add(count);
                maxDays = days[i];
                count = 1;
            }
        }
        
        answer.add(count);
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}