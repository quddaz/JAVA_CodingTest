import java.io.*;
import java.util.*;

public class S4_3085{
    static char map[][];
    static int maxResult = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new String[N];

        for(int i = 0; i < N; i++){
            map[i] = br.readLine().toCharArray();
        }
        solve();
        System.out.println(maxResult);

    }
    public static void solve(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N-1; j++){
                swap(i, j, i, j+1);
                search();
                swap(i, j, i, j+1);
            }
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N-1; j++){
                swap(j, i, j+1, i);
                search();
                swap(j, i, j+1, i);
            }
        }
    }
    private static void swap(int x1, int y1, int x2, int y2) {
        char temp = map[x1][y1];
        map[x1][y1] = map[x2][y2];
        map[x2][y2] = temp;
    }
    private static void search(){
        for(int i = 0; i < N; i++){
            int cnt = 1;
            for(int j = 0; j < N-1; j++){
                if(map[i][j] == map[i][j+1]){
                    cnt++;
                }else{
                    maxResult = Math.max(maxResult, cnt);
                    cnt= 1;
                }
            }
            maxResult = Math.max(maxResult, cnt);
        }
        for(int i = 0; i < N; i++){
            int cnt = 1;
            for(int j = 0; j < N-1; j++){
                if(map[j][i] == map[j+1][i]){
                    cnt++;
                }else{
                    maxResult = Math.max(maxResult, cnt);
                    cnt= 1;
                }
            }
            maxResult = Math.max(maxResult, cnt);
        }
    }
}
