import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int destination;
        int weight;

        Node(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    private static int V, E;
    private static List<List<Node>> adjacencyList;
    private static int[] distances;
    private static boolean[] visited;
    private static int startVertex;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken()); // 정점의 개수
        E = Integer.parseInt(st.nextToken()); // 간선의 개수
        startVertex = Integer.parseInt(br.readLine()); // 시작 정점

        // 인접 리스트 초기화
        adjacencyList = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // 간선 정보 입력
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adjacencyList.get(u).add(new Node(v, w));
        }
        // 거리 배열 및 방문 배열 초기화
        distances = new int[V + 1];
        Arrays.fill(distances, Integer.MAX_VALUE); // 거리 배열 초기화
        distances[startVertex] = 0;
        visited = new boolean[V + 1];

        // 다익스트라 알고리즘 수행
        dijkstra();

        // 결과 출력
        for (int i = 1; i <= V; i++) {
            if (distances[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(distances[i]);
            }
        }
    }

    // 다익스트라 알고리즘을 수행하는 스태틱 메소드
    private static void dijkstra() {
        // 우선순위 큐를 사용하여 최단 거리 노드를 효율적으로 선택
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // 시작 정점을 우선순위 큐에 추가 (거리 0으로 시작)
        pq.offer(new Node(startVertex, 0));

        // 우선순위 큐가 비어있지 않을 때까지 반복
        while (!pq.isEmpty()) {
            // 큐에서 가장 작은 거리의 노드를 꺼냄
            Node currentNode = pq.poll();
            int u = currentNode.destination;

            // 이미 방문한 노드는 무시
            if (visited[u])
                continue;
            visited[u] = true;

            // 현재 노드와 인접한 모든 노드에 대해
            for (Node neighbor : adjacencyList.get(u)) {
                int v = neighbor.destination; // 인접 노드
                int weight = neighbor.weight; // 간선의 가중치

                // 현재 노드를 통해 인접 노드로 가는 경로가 더 짧은지 확인
                if (distances[u] + weight < distances[v]) {
                    // 더 짧은 경로가 발견되면 거리 배열을 업데이트
                    distances[v] = distances[u] + weight;
                    // 업데이트된 경로를 우선순위 큐에 추가
                    pq.offer(new Node(v, distances[v]));
                }
            }
        }
    }
}