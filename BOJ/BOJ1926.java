import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[][] visited;
    static int N,M;
    static int start, end;
    static int max = 0;; 
    static int count = 0;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    //그래프 초기화
    public static void init(int N,int M){
        visited = new boolean[N][M];
        for(int i = 0; i<N; i++){
            graph.add(new ArrayList<Integer>());
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        init(N,M);
        for(int i = 0; i< N;i++){
            for(int j = 0; j<M;j++){
                graph.get(i).add(sc.nextInt());
            }
        }
        
        for(int i = 0; i< N;i++){
            for(int j = 0; j<M;j++){
                if(!visited[i][j]&&graph.get(i).get(j) == 1){
                    max = Math.max(dfs(i,j),max);
                    count++;
                }
            }
        }
        System.out.println(count +"\n"+max);
    }
    
    public static int dfs(int x, int y){
        visited[x][y] = true;
        int power = 1;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (isValid(nx, ny) &&!visited[nx][ny] && graph.get(nx).get(ny) == 1) {
                power += dfs(nx, ny);
            }
        }
        return power;
    }
    
        // 배열 범위 체크
    public static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}