class Solution {
    public int solution(int n, int[][] results) {
        int[][] map = new int[n + 1][n + 1];
        
        for (int[] result : results) {
            int winner = result[0];
            int loser = result[1];
            map[winner][loser] = 1;
            map[loser][winner] = -1;
        }
        
        // 플로이드-워셜 알고리즘 적용
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (map[i][k] == 1 && map[k][j] == 1) {
                        map[i][j] = 1; 
                    }
                    if (map[i][k] == -1 && map[k][j] == -1) {
                        map[i][j] = -1; 
                    }
                }
            }
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (map[i][j] != 0) {
                    count++;
                }
            }
            if (count == n - 1) { 
                answer++;
            }
        }
        
        return answer;
    }
}
