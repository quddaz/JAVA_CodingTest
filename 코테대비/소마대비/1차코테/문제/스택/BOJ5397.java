import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();
            String str = br.readLine();

            for (char c : str.toCharArray()) {
                if (c == '<') {
                    if (!left.isEmpty()) right.push(left.pop());
                } else if (c == '>') {
                    if (!right.isEmpty()) left.push(right.pop());
                } else if (c == '-') {
                    if (!left.isEmpty()) left.pop();
                } else {
                    left.push(c);
                }
            }

            StringBuilder sb = new StringBuilder();
            while (!left.isEmpty()) sb.append(left.pop());
            sb.reverse();
            while (!right.isEmpty()) sb.append(right.pop());

            System.out.println(sb);
        }
    }
}
