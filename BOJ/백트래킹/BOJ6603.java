import java.io.*;
import java.util.*;

public class Main {
    static int map[];
    static int n;
    static boolean visited[];
    static StringBuilder sb = new StringBuilder();
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            if(n == 0)
                break;

            map = new int[n];
            visited = new boolean[n];
            arr = new int[6];

            for(int i = 0; i < n; i++){
                map[i] = Integer.parseInt(st.nextToken());
            }

            solve(0, 0);
            sb.append('\n');
        }
        System.out.println(sb);
    }
    public static void solve(int depth, int start){
        if(depth == 6){
            for(int num : arr){
                sb.append(num).append(" ");
            }
            sb.append('\n');
            return;
        }

        for(int i = start; i < n; i++){
            arr[depth] = map[i];
            solve(depth+1, i+1);
        }
    }

}
