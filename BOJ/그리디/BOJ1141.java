import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine().trim();
        }

        Arrays.sort(words, (a, b) -> {
            if (a.length() == b.length()) return a.compareTo(b);
            return a.length() - b.length();
        });

        boolean[] removed = new boolean[N];

        for (int i = 0; i < N; i++) {
            if (removed[i]) continue;
            for (int j = i + 1; j < N; j++) {
                if (words[j].startsWith(words[i])) {
                    removed[i] = true; 
                    break;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (!removed[i]) count++;
        }
        System.out.println(count);
    }
}
