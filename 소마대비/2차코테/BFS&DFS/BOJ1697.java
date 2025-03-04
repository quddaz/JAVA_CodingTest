import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static boolean[] visited = new boolean[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{Integer.parseInt(st.nextToken()) ,0});
        
        int target = Integer.parseInt(st.nextToken());

        while(!q.isEmpty()){
            int cnt[] = q.poll();
            int t = cnt[0];
            int count = cnt[1];
            
            visited[t] = true;
            if(t == target){
                System.out.println(count);
                return;
            }
            if(t - 1 >= 0 && !visited[t - 1])
                q.add(new int[]{t - 1, count + 1});
            if(t + 1 <= 100000 && !visited[t + 1])
                q.add(new int[]{t + 1, count + 1});
            if(t * 2 <= 100000 && !visited[t * 2])
                q.add(new int[]{t * 2, count + 1});
        }

        System.out.println(-1);
    }
}