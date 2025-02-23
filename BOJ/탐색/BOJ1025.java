import java.io.*;

public class Main {
    static int N, M;
    static int[][] board;
    static int maxSquare = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);
        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        // 모든 시작 위치 탐색
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                // 모든 등차수열 탐색
                for (int dr = -N; dr <= N; dr++) {
                    for (int dc = -M; dc <= M; dc++) {
                        if (dr == 0 && dc == 0) continue;
                        findMaxSquare(r, c, dr, dc);
                    }
                }
            }
        }
        
        System.out.println(maxSquare);
    }

    static void findMaxSquare(int r, int c, int dr, int dc) {
        int num = 0;
        int x = r, y = c;

        while (x >= 0 && x < N && y >= 0 && y < M) {
            num = num * 10 + board[x][y];
            if (isPerfectSquare(num)) {
                maxSquare = Math.max(maxSquare, num);
            }
            x += dr;
            y += dc;
        }
    }

    static boolean isPerfectSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }
}
