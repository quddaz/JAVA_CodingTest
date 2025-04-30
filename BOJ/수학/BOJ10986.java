import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] count = new long[m];
        long[] prefix = new long[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            prefix[i] = (prefix[i - 1] + Integer.parseInt(st.nextToken())) % m;
        }

        long answer = 0;
        count[0] = 1; 

        for (int i = 1; i <= n; i++) {
            answer += count[(int)prefix[i]];
            count[(int)prefix[i]]++;
        }

        System.out.println(answer);
    }
}

