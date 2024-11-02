import java.util.Scanner;
 
public class Solution {
    static int maxScore = 0;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 수
 
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt(); // 재료 수
            int L = sc.nextInt(); // 제한 칼로리
            int[] scores = new int[N];
            int[] calories = new int[N];
 
            for (int i = 0; i < N; i++) {
                scores[i] = sc.nextInt();
                calories[i] = sc.nextInt();
            }
 
            // DFS를 시작
            dfs(0, 0, 0, scores, calories, L);
 
            // 결과 출력
            System.out.printf("#%d %d%n", t, maxScore);
            maxScore = 0; // 다음 테스트 케이스를 위해 초기화
        }
        sc.close();
    }
 
    static void dfs(int index, int currentScore, int currentCalories, int[] scores, int[] calories, int limit) {
        if (currentCalories > limit) return; // 칼로리 초과 시 종료
        maxScore = Math.max(maxScore, currentScore); // 최대 점수 갱신
 
        for (int i = index; i < scores.length; i++) {
            // 현재 재료 선택
            dfs(i + 1, currentScore + scores[i], currentCalories + calories[i], scores, calories, limit);
        }
    }
}