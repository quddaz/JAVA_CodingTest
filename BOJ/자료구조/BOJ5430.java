import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arrayStr = br.readLine();

            Deque<Integer> deque = new ArrayDeque<>();
            if (n > 0) {
                arrayStr = arrayStr.substring(1, arrayStr.length() - 1); // [1,2,3] -> 1,2,3
                StringTokenizer st = new StringTokenizer(arrayStr, ",");
                while (st.hasMoreTokens()) {
                    deque.add(Integer.parseInt(st.nextToken()));
                }
            }

            boolean isReversed = false;
            boolean isError = false;

            for (char cmd : p.toCharArray()) {
                if (cmd == 'R') {
                    isReversed = !isReversed;
                } else { // cmd == 'D'
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    }
                    if (isReversed) {
                        deque.pollLast();
                    } else {
                        deque.pollFirst();
                    }
                }
            }

            if (isError) {
                output.append("error\n");
            } else {
                output.append("[");
                while (!deque.isEmpty()) {
                    output.append(isReversed ? deque.pollLast() : deque.pollFirst());
                    if (!deque.isEmpty()) {
                        output.append(",");
                    }
                }
                output.append("]\n");
            }
        }

        System.out.print(output);
    }
}
