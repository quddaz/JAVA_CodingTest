import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static double answer;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static double[] prob = new double[4];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        for(int i = 0; i < 4; i++){
            prob[i] = (Double.parseDouble(st.nextToken()) / 100);
        }

        boolean[][] visited = new boolean[100][100];
        dfs(50, 50, visited, 0, 1);
        System.out.println(answer);
    }

    public static void dfs(int x, int y, boolean[][] visited, int count, double p){
        if(count == n){
            answer += p;
            return;
        }

        visited[x][y] = true;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i], ny = y + dy[i];
            if(!visited[nx][ny]){
                dfs(nx, ny, visited, count+1, p * prob[i]);
                visited[nx][ny] = false;
            }
        }
    }
}
