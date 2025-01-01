import java.io.*;
import java.util.*;


public class Main {
    static int n;
    static int a[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++){
            if(solve(Integer.parseInt(st.nextToken())))
                sb.append(1).append('\n');
            else
                sb.append(0).append('\n');
        }
        System.out.println(sb);
       
    }
    public static boolean solve(int num){
        int left = 0;
        int right = n - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(a[mid] == num) {
                return true;
            } else if(a[mid] < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }


        return false;
    }
}

