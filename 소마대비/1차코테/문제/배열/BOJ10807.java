import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<Integer, Integer> m = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int cnt = Integer.parseInt(st.nextToken());
            m.put(cnt, m.getOrDefault(cnt, 0) + 1);
        }
        System.out.println(m.getOrDefault(Integer.parseInt(br.readLine()), 0));
    }
}
