import java.io.*;
import java.util.*;

public class Main {
    static long result = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        solve(1, 3, n);
        System.out.println(result);
        System.out.println(sb);
    }

    public static void solve(int a, int b, int n){
        if(n == 1){
            sb.append(a + " "+ b + "\n");
            result++;
            return;
        }

        solve(a, 6 - a - b, n - 1);
        sb.append(a + " "+ b + "\n");
        result++;
        solve(6 - a - b, b, n - 1);
    }
}