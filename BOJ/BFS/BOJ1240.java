import java.io.*;
import java.util.*;

public class Main {

    static class Node{
        int node;
        int distance;
        Node(int node, int distance){
            this.node = node;
            this.distance = distance;
        }
    }
    static StringTokenizer st;
    static List<List<Node>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= n ; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < n - 1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, distance));
            graph.get(b).add(new Node(a, distance));
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            Queue<int[]> q = new LinkedList<>();
            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            q.add(new int[]{start, 0});
            boolean visited[] = new boolean[n + 1];
            visited[start] = true;

            while(!q.isEmpty()){
                int cnt[] = q.poll();
                int node = cnt[0];
                int count = cnt[1];

                if(node == target){
                    System.out.println(count);
                    break;
                }
                for(Node d : graph.get(node)){
                    if(!visited[d.node]){
                        q.add(new int[]{d.node, count + d.distance});
                        visited[d.node] = true;
                    }
                }
            }
        }
    }
}
