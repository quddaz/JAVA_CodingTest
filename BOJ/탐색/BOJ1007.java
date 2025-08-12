import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] points;
    static boolean[] selected; // 배열 선언 추가
    static long totalX, totalY;
    static double minDistanceSq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            
            points = new int[N][2];
            selected = new boolean[N]; // 배열 초기화 추가
            
            totalX = 0;
            totalY = 0;
            minDistanceSq = Double.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                points[i][0] = Integer.parseInt(st.nextToken());
                points[i][1] = Integer.parseInt(st.nextToken());
                totalX += points[i][0];
                totalY += points[i][1];
            }

            findCombinations(0, 0);
            
            sb.append(String.format("%.12f\n", Math.sqrt(minDistanceSq)));
        }
        System.out.print(sb);
    }

    public static void findCombinations(int index, int count) {
        if (count == N / 2) {
            long startX = 0;
            long startY = 0;
            
            for(int i = 0; i < N; i++) {
                if(selected[i]) {
                    startX += points[i][0];
                    startY += points[i][1];
                }
            }

            long vecSumX = totalX - 2 * startX;
            long vecSumY = totalY - 2 * startY;

            minDistanceSq = Math.min(minDistanceSq, (double)vecSumX * vecSumX + (double)vecSumY * vecSumY);
            return;
        }

        if (index == N) {
            return;
        }

        selected[index] = true;
        findCombinations(index + 1, count + 1);
        
        selected[index] = false;
        findCombinations(index + 1, count);
    }
}