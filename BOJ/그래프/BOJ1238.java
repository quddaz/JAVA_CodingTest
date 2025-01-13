import java.io.*;
import java.util.*;

public class Main {
    static class Road {
        int destination, time;

        Road(int destination, int time) {
            this.destination = destination;
            this.time = time;
        }
    }

    static List<List<Road>> graph = new ArrayList<>();
    static List<List<Road>> reverseGraph = new ArrayList<>();
    static int[] distFromX, distToX;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        distFromX = new int[N + 1];
        distToX = new int[N + 1];
        
        Arrays.fill(distFromX, Integer.MAX_VALUE);
        Arrays.fill(distToX, Integer.MAX_VALUE);

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Road(v, t));
            reverseGraph.get(v).add(new Road(u, t));
        }

        dijkstra(X, graph, distFromX);
        
        dijkstra(X, reverseGraph, distToX);

        int maxTime = 0;
        for (int i = 1; i <= N; i++) {
            if (i == X) continue;
            int totalTime = distFromX[i] + distToX[i];
            maxTime = Math.max(maxTime, totalTime);
        }

        System.out.println(maxTime);
    }

    public static void dijkstra(int start, List<List<Road>> graph, int[] dist) {
        PriorityQueue<Road> pq = new PriorityQueue<>(Comparator.comparingInt(r -> r.time));
        pq.add(new Road(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Road current = pq.poll();
            int currentNode = current.destination;
            int currentTime = current.time;

            if (dist[currentNode] < currentTime) {
                continue;
            }

            for (Road next : graph.get(currentNode)) {
                int newTime = currentTime + next.time;
                if (newTime < dist[next.destination]) {
                    dist[next.destination] = newTime;
                    pq.add(new Road(next.destination, newTime));
                }
            }
        }
    }
}
