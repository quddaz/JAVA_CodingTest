import java.io.*;
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
    static int n, m, start, end;
    static List<List<Node>> graph = new ArrayList<>(); 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        int max = 0;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));

            if(max < c)
                max = c;
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());


        int left = 1;
        int right = max;
        int answer = -1;
        while(left <= right){
            int mid = (left + right) / 2;

            if(bfs(mid)){
                answer = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }

    public static boolean bfs(int kg){
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[n + 1];
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int cnt = q.poll();

            if(cnt == end) return true;

            for(Node node : graph.get(cnt)){
                if(!visited[node.node] && node.dis >= kg){
                    visited[node.node] = true;
                    q.add(node.node);
                }
            }
        }

        return false;
    }

}
