import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Main {

    private static void solve(int n, int[][] B) {
        Arrays.sort(B, Comparator.comparingInt(o -> o[0]));
        int[] P = new int[n];
        for (int i = 0; i < n; i++)
            P[B[i][1]] = i;
        StringBuilder sb = new StringBuilder();
        for (int num : P)
            sb.append(num).append(' ');
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] B = new int[n][2];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();
        for (int i = 0; i < n; i++) {
            B[i][0] = Integer.parseInt(st.nextToken());
            B[i][1] = i;
        }
        solve(n, B);
    }
}