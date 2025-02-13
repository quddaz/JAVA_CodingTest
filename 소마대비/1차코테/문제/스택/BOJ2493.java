import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result[] = new int[n];
        Stack<int[]> s =  new Stack<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            int cnt = Integer.parseInt(st.nextToken());
            while(!s.isEmpty() && s.peek()[1] < cnt){
                s.pop();
            }
            if(!s.isEmpty())
                result[i-1] = s.peek()[1] > cnt ? s.peek()[0] : 0; 
            
            s.push(new int[]{i, cnt});
        }

        for(int i = 0; i < n; i++){
            System.out.print(result[i] + " ");
        }
    }

}
