import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] trucks = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trucks[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> bridge = new ArrayDeque<>();
        for (int i = 0; i < w; i++) {
            bridge.add(0);
        }

        int time = 0;
        int weightSum = 0;
        int idx = 0;

        while (idx < n) {
            time++;

            weightSum -= bridge.poll();

            if (weightSum + trucks[idx] <= L) {
                bridge.add(trucks[idx]);
                weightSum += trucks[idx];
                idx++;
            } else {
                bridge.add(0);
            }
        }

        time += w;

        System.out.println(time);
    }
}
