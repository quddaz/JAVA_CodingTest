import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = ' ';
            }
        }
        drawStar(0, 0, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(map[i]).append('\n');
        }
        System.out.print(sb);
    }
    public static void drawStar(int x, int y, int n){
        if(n == 3){
            map[x][y] = '*';
            map[x][y+1] = '*';
            map[x][y+2] = '*';
            map[x+1][y] = '*';
            map[x+1][y+2] = '*';
            map[x+2][y] = '*';
            map[x+2][y+1] = '*';
            map[x+2][y+2] = '*';
            return;
        }

        int newSize = n / 3;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(i == 1 && j == 1)
                    continue;
                drawStar(x + i * newSize, y + j * newSize, newSize);
            }
        }
    }
}