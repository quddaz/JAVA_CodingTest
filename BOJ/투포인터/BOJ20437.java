import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());

            ArrayList<Integer>[] pos = new ArrayList[26];
            for (int i = 0; i < 26; i++) {
                pos[i] = new ArrayList<>();
            }

            for (int i = 0; i < W.length(); i++) {
                pos[W.charAt(i) - 'a'].add(i);
            }

            int minLen = Integer.MAX_VALUE;
            int maxLen = Integer.MIN_VALUE;

            for (int c = 0; c < 26; c++) {
                if (pos[c].size() < K) continue;

                for (int i = 0; i + K - 1 < pos[c].size(); i++) {
                    int len = pos[c].get(i + K - 1) - pos[c].get(i) + 1;
                    minLen = Math.min(minLen, len);
                    maxLen = Math.max(maxLen, len);
                }
            }

            if (minLen == Integer.MAX_VALUE) {
                sb.append("-1\n");
            } else {
                sb.append(minLen).append(" ").append(maxLen).append("\n");
            }
        }

        System.out.print(sb.toString());
    }
}
