import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<String> results;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            results = new ArrayList<>();

            dfs(1, "1");

            for (String s : results) {
                System.out.println(s);
            }
            System.out.println(); 
        }
    }

    static void dfs(int num, String expr) {
        if (num == N) {
            if (evaluate(expr) == 0) {
                results.add(expr);
            }
            return;
        }

        dfs(num + 1, expr + " " + (num + 1));
        dfs(num + 1, expr + "+" + (num + 1)); 
        dfs(num + 1, expr + "-" + (num + 1)); 
    }

    static int evaluate(String expr) {
        String replaced = expr.replace(" ", ""); 
        StringTokenizer st = new StringTokenizer(replaced, "+-", true);

        int sum = Integer.parseInt(st.nextToken());
        while (st.hasMoreTokens()) {
            String op = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            if (op.equals("+")) sum += num;
            else sum -= num;
        }
        return sum;
    }
}