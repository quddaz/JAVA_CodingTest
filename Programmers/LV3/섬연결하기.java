import java.util.*;
class Solution {
    public static class Edge{
        int from;
        int to;
        int dist;
        Edge(int from, int to, int dist){
            this.from = from;
            this.to = to;
            this.dist = dist;
        }
    }
    static List<List<Edge>> li = new ArrayList<>();
    public int solution(int n, int[][] costs) {
        for(int i = 0; i < n; i++){
            li.add(new ArrayList<>());
        }
        
        for(int[] cost : costs){
            li.get(cost[0]).add(new Edge(cost[0], cost[1], cost[2]));
            li.get(cost[1]).add(new Edge(cost[1], cost[0], cost[2]));
        }
        int answer = 0;
        PriorityQueue<Edge> q = new PriorityQueue<>((a,b) -> a.dist - b.dist);
        boolean visited[] = new boolean[n];
        visited[0] = true;
        for(Edge e : li.get(0)){
            q.add(e);
        }
        
        while(!q.isEmpty()){
            Edge cnt = q.poll();
            if(visited[cnt.to]) continue;
            
            visited[cnt.to] = true;
            answer += cnt.dist;
            
            for(Edge e : li.get(cnt.to)){
                q.add(e);
            }
        }
        return answer;
    }
}