import java.util.*;
class Solution {
    public int solution(int n, int[][] costs) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] cost : costs) {
            int u = cost[0];
            int v = cost[1];
            int weight = cost[2];
            graph.get(u).add(new int[]{v, weight});
            graph.get(v).add(new int[]{u, weight});
        }
        
        boolean visited[] = new boolean[n];
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        q.add(new int[]{0,0});
        int result = 0;
        
        while(!q.isEmpty()){
            int cnt[] = q.poll();
            int island = cnt[0];
            int count = cnt[1];
            
            if(visited[island]) continue;
            visited[island] = true;
            result += count;
            for(int[] next : graph.get(island)){
                if(!visited[next[0]]){
                    q.add(new int[]{next[0], next[1]});
                }
            }
        }
        return result;
    }
}