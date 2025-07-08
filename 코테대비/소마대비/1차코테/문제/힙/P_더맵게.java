import java.util.*;
public class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int num : scoville){
            pq.add((long) num);
        }
        
        int count = 0;
        while(pq.size() > 1 && pq.peek() < K){
            long first = pq.poll();
            long second = pq.poll();
            count++;
            long sum = first + (second * 2);
            pq.add(sum);
        }
        if(pq.peek() < K)
            return -1;
        else
            return count;
    }
}