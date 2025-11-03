import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        int[] inDegree = new int[N + 1];
        int[] semester = new int[N + 1];
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(A).add(B);
            inDegree[B]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
                semester[i] = 1;
            }
        }
        
        while (!q.isEmpty()) {
            int now = q.poll();
            
            for (int next : graph.get(now)) {
                inDegree[next]--;
                if (semester[next] < semester[now] + 1) {
                    semester[next] = semester[now] + 1;
                }
                if (inDegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(semester[i]).append(" ");
        }
        
        System.out.println(sb.toString().trim());
    }
}
