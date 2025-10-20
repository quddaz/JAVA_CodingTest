import java.io.*;
import java.util.*;

public class Main {
    static class Teacher{
        int x,y;
        Teacher(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static List<Teacher> t = new ArrayList<>();
    static int n;
    static char map[][];
    static int moves[][] = {{1,0},{0,1},{-1,0},{0,-1}};
    static final int O_LIMIT = 3;
    static boolean result = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = st.nextToken();
                if(map[i][j] == 'T')
                    t.add(new Teacher(i, j));
            }
        }
        dfs(0);

        System.out.println(result ? "YES" : "NO");


    }
    public static void dfs(int depth){
        if (result) return;

        if(depth == O_LIMIT){
            if(check_teacher_surveillance())
                result = true;
            return;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] == 'X'){
                    map[i][j] = 'O';
                    dfs(depth + 1);
                    map[i][j] = 'X';
                }
            }
        }
    }
    public static boolean check_teacher_surveillance() {
        for (Teacher te : t) {
            for (int[] m : moves) {
                int x = te.x;
                int y = te.y;

                while (true) {
                    x += m[0];
                    y += m[1];

                    if (x < 0 || x >= n || y < 0 || y >= n)
                        break;

                    if (map[x][y] == 'O')
                        break;

                    if (map[x][y] == 'S')
                        return false;
                }
            }
        }
        return true;
    }

}
