import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());  
        int N = Integer.parseInt(st.nextToken());  

        long[] lengths = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            lengths[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(lengths);

        long low = 1;
        long high = lengths[N - 1];
        long result = 0;

        while (low <= high) {
            long mid = (low + high) / 2;
            if (canDivide(lengths, M, mid)) {
                result = mid;  
                low = mid + 1;
            } else {
                high = mid - 1; 
            }
        }

        System.out.println(result);
    }

    public static boolean canDivide(long[] lengths, int M, long length) {
        int count = 0;
        for (long l : lengths) {
            count += l / length;  
        }
        return count >= M; 
    }
}
