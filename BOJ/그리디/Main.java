import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int pos = Integer.parseInt(st.nextToken());
            if (pos < 0) left.add(-pos);
            else right.add(pos);
        }

        left.sort(Collections.reverseOrder());
        right.sort(Collections.reverseOrder());

        int maxDistance = 0;
        if (!left.isEmpty()) maxDistance = Math.max(maxDistance, left.get(0));
        if (!right.isEmpty()) maxDistance = Math.max(maxDistance, right.get(0));

        int total = 0;

        for (int i = 0; i < left.size(); i += M) {
            total += left.get(i) * 2;
        }

        for (int i = 0; i < right.size(); i += M) {
            total += right.get(i) * 2;
        }

        total -= maxDistance;

        System.out.println(total);
    }
}
