import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    static int n, m;
    static int[] arr;
    static int[] map;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        visited = new boolean[n];

        map = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(map);

        solve(0);
        System.out.println(sb);
    }

    public static void solve(int depth) {
        if(depth == m){
            for(int i = 0; i < m; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append('\n');
            return;
        }

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = map[i];
                solve(depth + 1); 
                visited[i] = false;
            }
        }
    }
}
