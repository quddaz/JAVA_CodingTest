class Solution {
    public int solution(int n, int[][] results) {
        int map[][] = new int[n + 1][n + 1];
        for(int[] result : results){
            int wi = result[0];
            int lo = result[1];
            map[wi][lo] = 1;
            map[lo][wi] = -1;
        }
        
        
        for(int k = 1; k <= n; k++){
            for(int j = 1; j <= n; j++){
                for(int i = 1; i <= n; i++){
                    if(map[i][k] == 1 && map[k][j] == 1)
                        map[i][j] = 1;
                    if(map[i][k] == -1 && map[k][j] == -1)
                        map[i][j] = -1;
                }
            }
        }
        int answer = 0;
        for(int i = 1; i <= n; i++){
            int count = 0;
            for(int j = 1; j <= n; j++){
                if(map[i][j] != 0)
                    count++;
            }
            if(count == n - 1)
                answer++;
        }
        return answer;
    }
}