import java.util.Scanner;

public class Main {
    static int N, M;
    static boolean[][] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        graph = new boolean[N+1][N+1];

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = true;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                if (graph[i][k]) { 
                    for (int j = 1; j <= N; j++) {
                        if (graph[k][j]) {
                            graph[i][j] = true;
                        }
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            int count = 0;
            for (int j = 1; j <= N; j++) {
                if (graph[i][j] || graph[j][i]) {
                    count++;
                }
            }
            if (count == N - 1) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
