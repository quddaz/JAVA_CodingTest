import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int map[][] = new int[n][n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j <= i; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for(int i = n - 2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                map[i][j] = Math.max(map[i + 1][j], map[i + 1][j + 1]) + map[i][j];
            }
        }

        System.out.println(map[0][0]);
    }
}

