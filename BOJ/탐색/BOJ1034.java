import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> rowCount = new HashMap<>();
        String[] rows = new String[N];

        for (int i = 0; i < N; i++) {
            rows[i] = br.readLine();
            rowCount.put(rows[i], rowCount.getOrDefault(rows[i], 0) + 1);
        }

        int K = Integer.parseInt(br.readLine());
        int max = 0;

        for (String row : rowCount.keySet()) {
            int zeroCount = 0;
            for (char c : row.toCharArray()) {
                if (c == '0') zeroCount++;
            }

            if (zeroCount <= K && (K - zeroCount) % 2 == 0) {
                max = Math.max(max, rowCount.get(row));
            }
        }

        System.out.println(max);
    }
}
