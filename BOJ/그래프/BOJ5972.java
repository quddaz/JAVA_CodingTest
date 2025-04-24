import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node{
        int node;
        int dis;

        Node(int node, int dis){
            this.node = node;
            this.dis = dis;
        }
    }
    static int dp[];
    static List<List<Node>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        q.add(new int[]{1,0});
        dp[1] = 0;

        while(!q.isEmpty()){
            int cnt[] = q.poll();
            int c = cnt[0];
            int dis = cnt[1];


            for(Node node : graph.get(c)){
                if(dp[node.node] > dis + node.dis){
                    q.add(new int[]{node.node, dis + node.dis });
                    dp[node.node] = dis + node.dis;
                }
            }
        }

        System.out.println(dp[n]);
    }
}
