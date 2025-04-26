import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static Map<Long, Long> memo = new HashMap<>();
    static long P, Q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());

        System.out.println(dfs(N));
    }

    static long dfs(long n) {
        if (n == 0) return 1;
        if (memo.containsKey(n)) return memo.get(n);

        long result = dfs(n / P) + dfs(n / Q);
        memo.put(n, result);
        return result;
    }
}
