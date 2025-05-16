import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int from, to, dis;
        Node(int from, int to, int dis) {
            this.from = from;
            this.to = to;
            this.dis = dis;
        }
    }
    static int n;
    static boolean[] visited;
    static int prev[];

    static int find(int x){
        if(prev[x] == x) return x;
        return prev[x] = find(prev[x]);
    }
    static boolean union(int a, int b){
        a = find(a);
        b = find(b);
        if(a == b) return false;
        prev[b] = a;
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        prev = new int[n + 2];
        visited = new boolean[n + 2];
        
        List<Node> graph = new ArrayList<>();


        for(int i = 1; i <= n; i++){
            graph.add(new Node(n + 1, i, Integer.parseInt(br.readLine())));
        }
        for(int i = 1; i <= n + 1; i++){
            prev[i] = i;
        }


        for(int i = 1; i <= n ;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                int cnt = Integer.parseInt(st.nextToken());
                if(i != j)
                    graph.add(new Node(i, j, cnt));
            }
        }

        Collections.sort(graph,(a,b) -> a.dis - b.dis);

        int sum = 0;
        for(Node no : graph){
            if(union(no.from, no.to)){
                sum += no.dis;
            }
        }

        System.out.println(sum);
    }

}
