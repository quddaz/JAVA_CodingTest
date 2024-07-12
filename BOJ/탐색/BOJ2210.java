import java.io.*;
import java.util.*;
public class Main {
    static int[][] board = new int[5][5];
    static Set<String> numbers = new HashSet<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 각 위치에서 시작하여 DFS 탐색
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, Integer.toString(board[i][j]));
            }
        }
        System.out.println(numbers.size());
    }
    public static void dfs(int x, int y, String number){

        if(number.length() >= 6){
            numbers.add(number);
            return;
        }
                // 상하좌우로 이동하면서 다음 위치로 재귀 호출
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    
                    if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                        dfs(nx, ny, number + board[nx][ny]);
                    }
                }
    }
}