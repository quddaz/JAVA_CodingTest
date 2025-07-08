import java.io.*;
import java.util.*;

public class Main {
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int arr[];
    static int flag[];
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        flag = new int[4];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            flag[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, flag, arr[0]);
        
        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int depth, int[] flag, int count){
        if(depth == n){
            min = Math.min(min, count);
            max = Math.max(max, count);
            return;
        }

        for(int i = 0; i < 4; i++){
            if(flag[i] > 0){
                flag[i] = flag[i] - 1;
                if(i == 0){
                    dfs(depth + 1, flag, count + arr[depth]);
                }else if(i == 1){
                    dfs(depth + 1, flag, count - arr[depth]);
                }else if(i == 2){
                    dfs(depth + 1, flag, count * arr[depth]);
                }else{
                    dfs(depth + 1, flag, count / arr[depth]);
                }
                flag[i] = flag[i] + 1;
            }
        }
    }
}
