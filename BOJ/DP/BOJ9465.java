import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 테스트 케이스 수 입력
        int T = sc.nextInt();

        // 테스트 케이스 반복
        while (T-- > 0) {
            int n = sc.nextInt();

            // 스티커 점수 배열 입력
            int[][] stickers = new int[2][n];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < n; j++) {
                    stickers[i][j] = sc.nextInt();
                }
            }

            // DP 배열 생성
            int[][] dp = new int[2][n];

            // 초기값 설정
            dp[0][0] = stickers[0][0];
            dp[1][0] = stickers[1][0];

            if (n > 1) {
                dp[0][1] = stickers[1][0] + stickers[0][1];
                dp[1][1] = stickers[0][0] + stickers[1][1];
            }

            // DP 점화식 적용
            for (int i = 2; i < n; i++) {
                dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + stickers[0][i];
                dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + stickers[1][i];
            }

            // 최종 결과 출력
            System.out.println(Math.max(dp[0][n-1], dp[1][n-1]));
        }
        sc.close();
    }
}
