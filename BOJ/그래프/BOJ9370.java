import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int to, weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    static int n, m, t, s, g, h;
    static List<List<Node>> graph;

    static int[] dijkstra(int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.weight > dist[now.to]) continue;

            for (Node next : graph.get(now.to)) {
                int cost = dist[now.to] + next.weight;

                if (cost < dist[next.to]) {
                    dist[next.to] = cost;
                    pq.add(new Node(next.to, cost));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            int ghCost = 0;

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                // 양방향 간선
                graph.get(a).add(new Node(b, d));
                graph.get(b).add(new Node(a, d));

                // g-h 간선의 거리 저장
                if ((a == g && b == h) || (a == h && b == g)) {
                    ghCost = d;
                }
            }

            List<Integer> candidates = new ArrayList<>();
            for (int i = 0; i < t; i++) {
                candidates.add(Integer.parseInt(br.readLine()));
            }

            // 3번 다익스트라
            int[] distFromS = dijkstra(s);
            int[] distFromG = dijkstra(g);
            int[] distFromH = dijkstra(h);

            List<Integer> answer = new ArrayList<>();

            for (int dest : candidates) {
                int path1 = distFromS[g] + ghCost + distFromH[dest];
                int path2 = distFromS[h] + ghCost + distFromG[dest];

                if (distFromS[dest] == path1 || distFromS[dest] == path2) {
                    answer.add(dest);
                }
            }

            Collections.sort(answer);
            for (int x : answer) {
                output.append(x).append(" ");
            }
            output.append("\n");
        }

        System.out.print(output);
    }
}
