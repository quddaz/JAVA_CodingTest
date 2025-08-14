import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] sensors = new int[N];
        for (int i = 0; i < N; i++) {
            sensors[i] = Integer.parseInt(st.nextToken());
        }

        if (K >= N) {
            System.out.println(0);
            return;
        }

        Arrays.sort(sensors);

        int[] dist = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            dist[i] = sensors[i + 1] - sensors[i];
        }

        Arrays.sort(dist);

        int sum = 0;
        for (int i = 0; i < N - K; i++) {
            sum += dist[i];
        }

        System.out.println(sum);
    }
}