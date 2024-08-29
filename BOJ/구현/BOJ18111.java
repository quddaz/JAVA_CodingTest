import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        int[][] minecraft = new int[N][M];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                minecraft[i][j] = Integer.parseInt(st.nextToken());
                if (minecraft[i][j] < min) min = minecraft[i][j];
                if (minecraft[i][j] > max) max = minecraft[i][j];
            }
        }
        
        int min_sec = Integer.MAX_VALUE;
        int high_block = 0;

        for (int i = min; i <= max; i++) {
            long second = 0;
            long block = B;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    int height = minecraft[j][k];
                    if (i > height) {
                        second += i - height;
                        block -= i - height;
                    } else if (i < height) {
                        second += (height - i) * 2;
                        block += height - i;
                    }
                }
            }
            
            if (block >= 0) {
                if (second < min_sec || (second == min_sec && i > high_block)) {
                    min_sec = (int) second;
                    high_block = i;
                }
            }
        }
        
        System.out.println(min_sec + " " + high_block);
    }
}
