import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        int[] prev = new int[n]; 
        Arrays.fill(prev, -1);

        List<Integer> lis = new ArrayList<>();
        List<Integer> lisIndices = new ArrayList<>(); 
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            int pos = Collections.binarySearch(lis, arr[i]);
            if (pos < 0) pos = -(pos + 1);

            if (pos == lis.size()) {
                lis.add(arr[i]);
                lisIndices.add(i);
            } else {
                lis.set(pos, arr[i]);
                lisIndices.set(pos, i);
            }

            if (pos > 0) prev[i] = lisIndices.get(pos - 1);
        }

        System.out.println(lis.size());

        int lastIndex = lisIndices.get(lisIndices.size() - 1);
        Stack<Integer> result = new Stack<>();
        while (lastIndex != -1) {
            result.push(arr[lastIndex]);
            lastIndex = prev[lastIndex];
        }

        while (!result.isEmpty()) {
            System.out.print(result.pop() + " ");
        }
    }
}
