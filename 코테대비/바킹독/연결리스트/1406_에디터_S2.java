import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for (int i = 0; i < n.length(); i++) {
            left.push(n.charAt(i));
        }

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("L") && !left.isEmpty()) {
                right.push(left.pop());
            } else if (cmd.equals("D") && !right.isEmpty()) {
                left.push(right.pop());
            } else if (cmd.equals("B") && !left.isEmpty()) {
                left.pop();
            } else if (cmd.equals("P")) {
                char ch = st.nextToken().charAt(0);
                left.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : left) sb.append(c);
        while (!right.isEmpty()) sb.append(right.pop());

        System.out.println(sb);
    }
}
