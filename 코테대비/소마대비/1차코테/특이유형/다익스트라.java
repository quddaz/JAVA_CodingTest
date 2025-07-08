import java.io.*;
import java.util.*;

public class Main {
    public static class Node{
        int node;
        int distanse;
        Node(int node, int distanse){
            this.node = node;
            this.distanse = distanse;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int startNode = Integer.parseInt(br.readLine());

        List<List<Node>> graph = new ArrayList<>();
        for(int i = 0; i <= v; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int di = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, di));
        }

        
        int dis[] = new int[v + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        boolean visited[] = new boolean[v + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.distanse - b.distanse);
        dis[startNode] = 0;
        pq.add(new Node(startNode, 0));

        while(!pq.isEmpty()){
            Node cnt = pq.poll();

            if(visited[cnt.node]) continue;

            visited[cnt.node] = true;

            for(Node node : graph.get(cnt.node)){
                if(dis[cnt.node] + node.distanse < dis[node.node]){
                    dis[node.node] = dis[cnt.node] + node.distanse;
                    pq.add(new Node(node.node, dis[node.node]));
                }
            }
        }
        
        for(int i = 1; i <= v; i++){
            if(dis[i] == Integer.MAX_VALUE)
                System.out.println("INF");
            else
                System.out.println(dis[i]);
        }
    }
}
