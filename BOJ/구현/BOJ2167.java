import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 배열 크기 입력
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 원본 배열 및 누적 합 배열 선언
        int[][] arr = new int[N + 1][M + 1];
        int[][] sum = new int[N + 1][M + 1];

        // 배열 입력 및 누적 합 계산
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                arr[i][j] = sc.nextInt();
                sum[i][j] = arr[i][j] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
            }
        }

        // 쿼리 개수 입력
        int K = sc.nextInt();

        // 각 쿼리에 대해 구간 합 계산 및 출력
        for (int q = 0; q < K; q++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            int result = sum[x][y] - sum[x][j - 1] - sum[i - 1][y] + sum[i - 1][j - 1];
            System.out.println(result);
        }

        sc.close();
    }
}
