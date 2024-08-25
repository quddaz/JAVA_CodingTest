import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int city, cost;

        public Node(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost; 
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); 
        int M = sc.nextInt();

        // 그래프 초기화
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프 정보 입력
        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int cost = sc.nextInt();
            graph.get(start).add(new Node(end, cost));
        }

        int startCity = sc.nextInt();
        int endCity = sc.nextInt(); 


        int[] minCost = dijkstra(N, graph, startCity);

        System.out.println(minCost[endCity]);
    }

    private static int[] dijkstra(int N, List<List<Node>> graph, int startCity) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] minCost = new int[N + 1];
        Arrays.fill(minCost, Integer.MAX_VALUE);

        minCost[startCity] = 0;
        pq.add(new Node(startCity, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentCity = current.city;
            int currentCost = current.cost;

            if (currentCost > minCost[currentCity]) continue;

            // 인접한 노드 탐색
            for (Node neighbor : graph.get(currentCity)) {
                int newCost = currentCost + neighbor.cost;

                if (newCost < minCost[neighbor.city]) {
                    minCost[neighbor.city] = newCost;
                    pq.add(new Node(neighbor.city, newCost));
                }
            }
        }

        return minCost;
    }
}
