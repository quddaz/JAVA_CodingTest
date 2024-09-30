import java.util.*;
import java.util.stream.IntStream;
public class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        IntStream.of(scoville).forEach(pq::offer);  // 배열을 우선순위 큐에 넣기

        int count = 0;
        while (pq.size() > 1 && pq.peek() < K) {
            pq.offer(pq.poll() + pq.poll() * 2);
            count++;
        }
        return pq.peek() >= K ? count : -1;
    }
}