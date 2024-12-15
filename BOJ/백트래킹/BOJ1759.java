import java.io.*;
import java.util.*;

public class Main {
    static int l, c;
    static char[] arr; 
    static StringBuilder sb = new StringBuilder();
    static Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u'); // 모음 세트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken()); 
        c = Integer.parseInt(st.nextToken()); 

        arr = new char[c];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr); 

        solve(0, 0, 0, 0, new StringBuilder());

        System.out.print(sb);
    }

    public static void solve(int depth, int start, int vowelCount, int consonantCount, StringBuilder current) {
        if (depth == l) {
            if (vowelCount >= 1 && consonantCount >= 2) {
                sb.append(current).append('\n');
            }
            return;
        }


        for (int i = start; i < c; i++) {
            char ch = arr[i];
            current.append(ch); 

            if (vowels.contains(ch)) {
                solve(depth + 1, i + 1, vowelCount + 1, consonantCount, current);
            } else {
                solve(depth + 1, i + 1, vowelCount, consonantCount + 1, current);
            }

            current.deleteCharAt(current.length() - 1);
        }
    }
}
