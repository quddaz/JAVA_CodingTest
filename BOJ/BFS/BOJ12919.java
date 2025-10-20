import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String t = br.readLine();

        int result = 0;

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(t);
        visited.add(t);

        while (!queue.isEmpty()) {
            String currentStr = queue.poll();

            if (currentStr.equals(s)) {
                result = 1;
                break;
            }

            if (currentStr.length() < s.length()) {
                continue;
            }

            if (currentStr.endsWith("A")) {
                String nextStr = currentStr.substring(0, currentStr.length() - 1);
                if (!visited.contains(nextStr)) {
                    queue.add(nextStr);
                    visited.add(nextStr);
                }
            }

            if (currentStr.startsWith("B")) {
                String temp = currentStr.substring(1);
                String nextStr = new StringBuilder(temp).reverse().toString();
                
                if (!visited.contains(nextStr)) {
                    queue.add(nextStr);
                    visited.add(nextStr);
                }
            }
        }

        System.out.println(result);
    }
}