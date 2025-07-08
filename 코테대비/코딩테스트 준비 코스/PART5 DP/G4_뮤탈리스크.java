import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G4_12869 {
    static int[] num;
    static int N;
    static int[][][] dp;
    static final int[][] ATTACKS = {
        {9, 3, 1},
        {9, 1, 3},
        {3, 9, 1},
        {3, 1, 9},
        {1, 9, 3},
        {1, 3, 9}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        num = new int[3];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        
        // DP 배열을 60으로 초기화 (최대 체력 60)
        dp = new int[61][61][61];
        for (int[][] matrix : dp) {
            for (int[] row : matrix) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
        }

        bfs();
        // dp[0][0][0]에 저장된 최소 공격 횟수 출력
        System.out.println(dp[0][0][0]);
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        // 초기 상태와 공격 횟수 0
        queue.add(new int[]{num[0], num[1], num[2]});
        dp[num[0]][num[1]][num[2]] = 0;

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int num1 = arr[0];
            int num2 = arr[1];
            int num3 = arr[2];
            int currentCount = dp[num1][num2][num3];
            
            // 가능한 모든 공격 패턴 적용
            for (int[] attack : ATTACKS) {
                int move1 = Math.max(num1 - attack[0], 0);
                int move2 = Math.max(num2 - attack[1], 0);
                int move3 = Math.max(num3 - attack[2], 0);
                
                if (dp[move1][move2][move3] > currentCount + 1) {
                    dp[move1][move2][move3] = currentCount + 1;
                    queue.add(new int[]{move1, move2, move3});
                }
            }
        }
    }
}
