import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        for (int t = 1; t <= 10; t++) {
            int testCaseNumber = Integer.parseInt(br.readLine()); // 테스트 케이스 번호
            int[][] map = new int[100][100];
 
            // 2차원 배열 입력 받기
            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
 
            // 최대값을 찾기 위한 변수
            int maxSum = Integer.MIN_VALUE;
 
            // 각 행의 합 계산
            for (int i = 0; i < 100; i++) {
                int rowSum = 0;
                for (int j = 0; j < 100; j++) {
                    rowSum += map[i][j];
                }
                maxSum = Math.max(maxSum, rowSum);
            }
 
            // 각 열의 합 계산
            for (int j = 0; j < 100; j++) {
                int colSum = 0;
                for (int i = 0; i < 100; i++) {
                    colSum += map[i][j];
                }
                maxSum = Math.max(maxSum, colSum);
            }
 
            // 대각선의 합 계산 (왼쪽 상단에서 오른쪽 하단)
            int diagonalSum1 = 0;
            for (int i = 0; i < 100; i++) {
                diagonalSum1 += map[i][i];
            }
            maxSum = Math.max(maxSum, diagonalSum1);
 
            // 대각선의 합 계산 (오른쪽 상단에서 왼쪽 하단)
            int diagonalSum2 = 0;
            for (int i = 0; i < 100; i++) {
                diagonalSum2 += map[i][99 - i];
            }
            maxSum = Math.max(maxSum, diagonalSum2);
 
            // 결과 출력
            System.out.println("#" + testCaseNumber + " " + maxSum);
        }
    }
}