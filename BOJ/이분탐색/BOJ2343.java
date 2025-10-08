import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] lectures;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lectures = new int[N];
        st = new StringTokenizer(br.readLine());
        int maxLen = 0;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
            maxLen = Math.max(maxLen, lectures[i]);
            sum += lectures[i];
        }

        int left = maxLen;
        int right = sum;
        int answer = sum;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (canDivide(mid)) { 
                answer = mid;
                right = mid - 1; 
            } else {
                left = mid + 1; 
            }
        }

        System.out.println(answer);
    }

    static boolean canDivide(int size) {
        int count = 1; 
        int total = 0;

        for (int len : lectures) {
            if (total + len > size) {
                count++;
                total = 0;
            }
            total += len;
        }

        return count <= M;
    }
}
