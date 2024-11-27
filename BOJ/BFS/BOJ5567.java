import java.util.*;
import java.io.*;

class Main {
    static int n, m;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        visited = new boolean[n + 1];

        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        System.out.println(bfs());

    }

    public static int bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0});
        visited[1] = true;
        int count = 0;

        while (!q.isEmpty()) {
            int cnt[] = q.poll();
            int num = cnt[0];
            int depth = cnt[1];

            if(depth == 2)
                continue;
                
            for(int gr : graph.get(num)){
                if(!visited[gr]){
                    q.add(new int[]{gr, depth + 1});
                    visited[gr] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
