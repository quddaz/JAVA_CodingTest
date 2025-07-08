import java.util.*;

public class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a,b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        
        
        
        int count = jobs.length;
        int time = 0;
        int result =0;
        int idx = 0;
        while(idx < count || !pq.isEmpty()){
            while(idx < count && time >= jobs[idx][0]){
                pq.add(jobs[idx]);
                idx++;
            }
            
            if(pq.isEmpty()){
                time = jobs[idx][0];
            }else{
                int cnt[] = pq.poll();
                time += cnt[1];
                result += time -  cnt[0];
            }
        }
        
        return result / count;
    }
}
