import java.util.*;
import java.io.*;

class Main {
    static int N, E;
    static List<List<Node>> graph;
    static final int INF = 200000000;

    static class Node implements Comparable<Node> {
        int vertex;
        int weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return this.weight - other.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[] dist1 = dijkstra(1);
        int[] distV1 = dijkstra(v1);
        int[] distV2 = dijkstra(v2);

        // 1 -> v1 -> v2 -> N
        int route1 = dist1[v1] + distV1[v2] + distV2[N];

        // 1 -> v2 -> v1 -> N
        int route2 = dist1[v2] + distV2[v1] + distV1[N];

        int result = Math.min(route1, route2);

        if (result >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    static int[] dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentVertex = current.vertex;
            int currentWeight = current.weight;

            if (dist[currentVertex] < currentWeight) {
                continue;
            }

            for (Node neighbor : graph.get(currentVertex)) {
                int nextVertex = neighbor.vertex;
                int weight = neighbor.weight;
                if (dist[nextVertex] > dist[currentVertex] + weight) {
                    dist[nextVertex] = dist[currentVertex] + weight;
                    pq.add(new Node(nextVertex, dist[nextVertex]));
                }
            }
        }

        return dist;
    }
}
