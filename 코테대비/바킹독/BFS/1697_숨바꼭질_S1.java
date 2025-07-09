import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int map[] = new int[100001];
        visited = new boolean[100001];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{n,0});
        visited[n] = true;

        while(!q.isEmpty()){
            int cnt[] = q.poll();

            if(cnt[0] == m){
                System.out.println(cnt[1]);
                return;
            }

            if(cnt[0] + 1 <= 100000 && !visited[cnt[0] + 1]){
                visited[cnt[0] + 1] = true;
                q.add(new int[]{cnt[0] + 1, cnt[1] + 1});
            }

            if(cnt[0] * 2 <= 100000 && !visited[cnt[0] * 2]){
                visited[cnt[0] * 2] = true;
                q.add(new int[]{cnt[0] * 2, cnt[1] + 1});
            }

            if(cnt[0] - 1 >= 0 && !visited[cnt[0] - 1]){
                visited[cnt[0] - 1] = true;
                q.add(new int[]{cnt[0] - 1, cnt[1] + 1});
            }
        }
    }

}