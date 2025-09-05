import java.io.*;
import java.util.*;

public class Main {
    static int s, N, K, R1, R2, C1, C2;

    static int getColor(int s, int N, int K, int r, int c) {
        if (s == 0) return 0; 

        int size = (int) Math.pow(N, s - 1); 
        int row = r / size;
        int col = c / size;

        int midStart = (N - K) / 2;
        int midEnd = midStart + K - 1;

        if (row >= midStart && row <= midEnd &&
            col >= midStart && col <= midEnd) {
            return 1;
        }

        return getColor(s - 1, N, K, r % size, c % size);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        s = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R1 = Integer.parseInt(st.nextToken());
        R2 = Integer.parseInt(st.nextToken());
        C1 = Integer.parseInt(st.nextToken());
        C2 = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        for (int r = R1; r <= R2; r++) {
            for (int c = C1; c <= C2; c++) {
                sb.append(getColor(s, N, K, r, c));
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
