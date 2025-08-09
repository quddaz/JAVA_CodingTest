import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> lis = new ArrayList<>();
        for (int num : arr) {
            int pos = Collections.binarySearch(lis, num);
            if (pos < 0) pos = -(pos + 1);
            if (pos == lis.size()) lis.add(num);
            else lis.set(pos, num);
        }

        System.out.println(N - lis.size());
    }
}
