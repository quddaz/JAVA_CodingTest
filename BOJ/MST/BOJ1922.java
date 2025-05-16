import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        int from;
        int to;
        int weight;

        Node(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

    }
    static int n,m;
    static int prev[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        prev = new int[n + 1];

        for(int i = 1; i <= n; i++) prev[i] = i;

        List<Node> graph = new ArrayList<>();

        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int we = Integer.parseInt(st.nextToken());

            graph.add(new Node(from, to, we));
        }

        Collections.sort(graph, (a,b) -> a.weight - b.weight);

        int sum = 0;
        for(Node no : graph){
            if(union(no.from, no.to)){
                sum += no.weight;
            }
        }

        System.out.println(sum);

    }

    public static int find(int x){
        if(prev[x] == x) return x;

        return prev[x] = find(prev[x]);
    }

    public static boolean union(int a, int b){
        a = find(a);
        b = find(b);
        if(a == b) return false;
        prev[b] = a;
        return true;
    }

}
