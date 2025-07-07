import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int result[] = new int[n];
        Arrays.fill(result, -1);

        Stack<int[]> s = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int cnt = Integer.parseInt(st.nextToken());
            while(!s.isEmpty() && s.peek()[0] < cnt){
                result[s.pop()[1]] = cnt;
            }

            s.push(new int[]{cnt, i});
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append(result[i]).append(' ');
        }
        System.out.println(sb);
    }
}
