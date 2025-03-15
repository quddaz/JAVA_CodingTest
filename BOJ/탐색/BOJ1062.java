import java.io.*;
import java.util.*;

public class Main {
    static int N, K, maxWords = 0;
    static List<String> words = new ArrayList<>();
    static boolean[] learned = new boolean[26];
    static final char[] REQUIRED = {'a', 'n', 't', 'i', 'c'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (K < 5) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            words.add(word.substring(4, word.length() - 4));
        }

        for (char c : REQUIRED) {
            learned[c - 'a'] = true;
        }

        findMaxWords(0, 0);
        System.out.println(maxWords);
    }

    static void findMaxWords(int idx, int count) {
        if (count == K - 5) {
            maxWords = Math.max(maxWords, countReadableWords());
            return;
        }

        for (int i = idx; i < 26; i++) {
            if (!learned[i]) {
                learned[i] = true;
                findMaxWords(i + 1, count + 1);
                learned[i] = false;
            }
        }
    }

    static int countReadableWords() {
        int count = 0;
        for (String word : words) {
            boolean canRead = true;
            for (char c : word.toCharArray()) {
                if (!learned[c - 'a']) {
                    canRead = false;
                    break;
                }
            }
            if (canRead) count++;
        }
        return count;
    }
}
