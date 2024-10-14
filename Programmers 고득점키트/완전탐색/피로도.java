public class Solution {
    private static int maxDungeons;
    private static int[][] dungeons;
    private static boolean[] visited;

    public static int solution(int k, int[][] inputDungeons) {
        maxDungeons = 0;
        dungeons = inputDungeons;
        visited = new boolean[dungeons.length];

        dfs(k, 0);
        return maxDungeons;
    }

    private static void dfs(int fatigue, int count) {
        maxDungeons = Math.max(maxDungeons, count);

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && fatigue >= dungeons[i][0]) { 
                visited[i] = true;
                dfs(fatigue - dungeons[i][1], count + 1); 
                visited[i] = false; // 백트래킹
            }
        }
    }
}
