import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙
        PriorityQueue<Integer> right = new PriorityQueue<>(); // 최소 힙

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            left.offer(num);
            if (!right.isEmpty() && left.peek() > right.peek()) {
                right.offer(left.poll());
                left.offer(right.poll());
            }
            if (left.size() > right.size() + 1) {
                right.offer(left.poll());
            }

            sb.append(left.peek()).append('\n');
        }

        System.out.print(sb);
    }
}
