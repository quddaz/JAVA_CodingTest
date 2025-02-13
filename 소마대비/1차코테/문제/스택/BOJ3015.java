import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<int[]> s = new Stack<>();

        long result = 0;
        for(int i = 0; i < n; i++){
            int cnt = Integer.parseInt(br.readLine());
            int count = 1;

            while(!s.isEmpty() && s.peek()[0] <= cnt){
                int[] top = s.pop();
                result += top[1];

                if(top[0] == cnt){
                    count += top[1];
                }
            }

            if(!s.isEmpty()){
                result++;
            }
            s.push(new int[]{cnt, count});
        }

        System.out.println(result);
    }
}
