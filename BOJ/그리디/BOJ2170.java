import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<int[]> lines = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            lines.add(new int[]{x, y});
        }

        lines.sort((a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        long totalLength = 0;
        int start = lines.get(0)[0];
        int end = lines.get(0)[1];

        for (int i = 1; i < n; i++) {
            int[] current = lines.get(i);
            if (current[0] <= end) {
                end = Math.max(end, current[1]);
            } else {
                totalLength += end - start;
                start = current[0];
                end = current[1];
            }
        }

        totalLength += end - start;
        System.out.println(totalLength);
    }
}
