import java.util.*;

public class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        int time = 0; 
        int totalTime = 0;  
        int idx = 0;  
        int count = jobs.length; 

        while (idx < count || !pq.isEmpty()) {
            while (idx < count && jobs[idx][0] <= time) {
                pq.offer(jobs[idx]);
                idx++;
            }

            if (!pq.isEmpty()) {
                int[] job = pq.poll();
                time += job[1]; 
                totalTime += time - job[0];
            } else {
                time = jobs[idx][0];
            }
        }

        return totalTime / count;
    }
}
