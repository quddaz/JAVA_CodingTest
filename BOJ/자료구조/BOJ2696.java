import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int M = Integer.parseInt(br.readLine());
            List<Integer> nums = new ArrayList<>();

            while (nums.size() < M) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens()) {
                    nums.add(Integer.parseInt(st.nextToken()));
                }
            }

            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // Left
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // Right

            List<Integer> medians = new ArrayList<>();

            for (int i = 0; i < M; i++) {
                int num = nums.get(i);

                if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                    maxHeap.add(num);
                } else {
                    minHeap.add(num);
                }

                if (maxHeap.size() > minHeap.size() + 1) {
                    minHeap.add(maxHeap.poll());
                } else if (minHeap.size() > maxHeap.size()) {
                    maxHeap.add(minHeap.poll());
                }

                if (i % 2 == 0) {
                    medians.add(maxHeap.peek());
                }
            }

            output.append(medians.size()).append("\n");
            for (int i = 0; i < medians.size(); i++) {
                output.append(medians.get(i)).append(" ");
                if ((i + 1) % 10 == 0) {
                    output.append("\n");
                }
            }
            if (medians.size() % 10 != 0) output.append("\n");
        }

        System.out.print(output);
    }
}
