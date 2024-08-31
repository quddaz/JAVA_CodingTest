import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // N: 수의 개수, M: 합을 구해야 하는 횟수
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        int[] arr = new int[N + 1]; // 원본 배열 (1-indexed)
        int[] sum = new int[N + 1]; // 누적 합 배열 (1-indexed)
        
        // 배열 입력 및 누적 합 계산
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
            sum[i] = sum[i - 1] + arr[i];
        }
        
        // 구간 합 계산
        for (int k = 0; k < M; k++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            System.out.println(sum[j] - sum[i - 1]);
        }
        
        sc.close();
    }
}
