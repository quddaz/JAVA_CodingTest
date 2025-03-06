import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int vertex, weight;
    
    public Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
    
    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.weight, o.weight);
    }
}

public class Main {
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            graph[A].add(new Node(B, C));
            graph[B].add(new Node(A, C));
        }

        System.out.println(prim(V));
    }

    static int prim(int V) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[V + 1];
        pq.add(new Node(1, 0));

        int mstWeight = 0, count = 0;
        while (!pq.isEmpty() && count < V) {
            Node node = pq.poll();
            if (visited[node.vertex]) continue;
            visited[node.vertex] = true;
            mstWeight += node.weight;
            count++;

            for (Node next : graph[node.vertex]) {
                if (!visited[next.vertex]) pq.add(next);
            }
        }

        return mstWeight;
    }
}
