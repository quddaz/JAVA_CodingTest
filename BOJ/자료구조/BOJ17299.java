import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Integer, Integer> m = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int map[] = new int[N];
        for(int i = 0; i < N; i++){
            int cnt = Integer.parseInt(st.nextToken());
            m.put(cnt, m.getOrDefault(cnt, 0) + 1);
            map[i] = cnt;
        } 

        Stack<int[]> s = new Stack<>();
        int result[] = new int[N];
        Arrays.fill(result, -1);

        for(int i = 0; i < N; i++){
            while(!s.isEmpty() && s.peek()[0] < m.get(map[i])){
                int cnt[] = s.pop();
                result[cnt[1]] = map[i];
            }

            s.push(new int[]{m.get(map[i]), i});
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            sb.append(result[i] + " ");
        }

        System.out.println(sb);
    }
}
