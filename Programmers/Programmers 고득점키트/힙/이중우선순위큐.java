import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (String operation : operations) {
            String[] parts = operation.split(" ");
            String command = parts[0];
            int number = Integer.parseInt(parts[1]);

            if (command.equals("I")) {
                // 삽입 연산
                minHeap.offer(number);
                maxHeap.offer(number);
            } else if (command.equals("D") && number == 1 && !maxHeap.isEmpty()) {
                // 최댓값 삭제
                int max = maxHeap.poll();
                minHeap.remove(max);
            } else if (command.equals("D") && number == -1 && !minHeap.isEmpty()) {
                // 최솟값 삭제
                int min = minHeap.poll();
                maxHeap.remove(min);
            }
        }

        if (maxHeap.isEmpty()) {
            return new int[]{0, 0};  // 큐가 비어있으면 [0, 0] 반환
        }

        int max = maxHeap.peek();
        int min = minHeap.peek();
        return new int[]{max, min};
    }
}

