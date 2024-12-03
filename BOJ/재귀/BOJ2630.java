import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    static int blue = 0;
    static int white = 0;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        func(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }

    public static void func(int x, int y, int n) {
        if (valid(x, y, n)) {
            if (map[x][y] == 1)
                blue++;
            else
                white++;
            return;
        }
        int half = n / 2;
        func(x, y, half); // 왼쪽 위
        func(x + half, y, half); // 오른쪽 위
        func(x, y + half, half); // 왼쪽 아래
        func(x + half, y + half, half); // 오른쪽 아래
    }

    public static boolean valid(int x, int y, int n) {
        int temp = map[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (temp != map[i][j])
                    return false;
            }
        }
        return true;
    }
}
