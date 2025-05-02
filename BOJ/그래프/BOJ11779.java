import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int node;
        int dis;
        Node(int node, int dis){
            this.node = node;
            this.dis = dis;
        }

        public int compareTo(Node o){
            return Integer.compare(this.dis, o.dis);
        }
    }

    static int n, m;
    static List<List<Node>> graph = new ArrayList<>();
    static int start, end;
    static int[] minDis;
    static int[] prev;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        minDis = new int[n + 1];
        prev = new int[n + 1];
        Arrays.fill(minDis, Integer.MAX_VALUE);
        Arrays.fill(prev, -1); 

        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, dis));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijkstra();

        System.out.println(minDis[end]);

        List<Integer> path = new ArrayList<>();
        for (int at = end; at != -1; at = prev[at]) {
            path.add(at);
        }
        Collections.reverse(path);

        System.out.println(path.size());
        for (int p : path) {
            System.out.print(p + " ");
        }
    }

    public static void dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        minDis[start] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int now = curr.node;
            int dist = curr.dis;

            if (minDis[now] < dist) continue;

            for (Node next : graph.get(now)) {
                int cost = dist + next.dis;
                if (cost < minDis[next.node]) {
                    minDis[next.node] = cost;
                    prev[next.node] = now;
                    pq.add(new Node(next.node, cost));
                }
            }
        }
    }
}
