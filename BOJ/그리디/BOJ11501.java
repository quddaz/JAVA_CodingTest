import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트케이스 수
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine()); // 날의 수
            StringTokenizer st = new StringTokenizer(br.readLine());
            long[] prices = new long[N];

            for (int i = 0; i < N; i++) {
                prices[i] = Long.parseLong(st.nextToken());
            }

            long maxPrice = 0;
            long profit = 0;

            // 뒤에서부터 최대값 갱신 및 이익 계산
            for (int i = N - 1; i >= 0; i--) {
                if (prices[i] > maxPrice) {
                    maxPrice = prices[i];
                } else {
                    profit += maxPrice - prices[i];
                }
            }

            sb.append(profit).append("\n");
        }

        System.out.print(sb);
    }
}
