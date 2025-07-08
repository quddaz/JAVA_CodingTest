import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_1697 {

    static int map[];
    static int N,K,max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[100001];
        int result = bfs(N);
        System.out.println(result);
    }
    public static int bfs(int i){
        Queue<Integer> queue  = new LinkedList<>();
        queue.add(i);
        while(!queue.isEmpty()) {
            int n = queue.poll();
            if (n == K) {
                return map[n];
            }
            if (n - 1 >= 0 && map[n - 1] == 0) {
                map[n - 1] = map[n] + 1;
                queue.add(n-1);
            }
            if (n + 1 <= 100000 && map[n + 1] == 0){
                map[n+1] = map[n]+1;
                queue.add(n+1);
            }
            if(2*n <= 100000 && map[2*n] == 0){
                map[2*n] = map[n]+1;
                queue.add(2*n);
            }
        }
        return -1;
    }
}