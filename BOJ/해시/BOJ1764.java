import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> heard = new HashSet<>(N);

        for (int i = 0; i < N; i++) {
            heard.add(br.readLine());
        }

        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (heard.contains(name)) {
                result.add(name);
            }
        }

        Collections.sort(result);

        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append('\n');
        for (String name : result) {
            sb.append(name).append('\n');
        }

        System.out.println(sb);
    }
}
