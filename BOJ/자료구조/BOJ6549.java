import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;

            int[] heights = new int[n];
            for (int i = 0; i < n; i++) {
                heights[i] = Integer.parseInt(st.nextToken());
            }

            Stack<Integer> stack = new Stack<>();
            long maxArea = 0;

            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                    int height = heights[stack.pop()];
                    int width = stack.isEmpty() ? i : (i - stack.peek() - 1);
                    maxArea = Math.max(maxArea, (long) height * width);
                }
                stack.push(i);
            }

            while (!stack.isEmpty()) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? n : (n - stack.peek() - 1);
                maxArea = Math.max(maxArea, (long) height * width);
            }

            sb.append(maxArea).append("\n");
        }
        System.out.print(sb);
    }
}
