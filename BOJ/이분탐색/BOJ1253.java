import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);  
        int goodCount = 0;

        for (int i = 0; i < N; i++) {
            if (isGoodNumber(A, i, N)) {
                goodCount++;
            }
        }

        sb.append(goodCount).append("\n");
        System.out.print(sb);
    }

    private static boolean isGoodNumber(int[] A, int index, int N) {
        int target = A[index];
        int left = 0, right = N - 1;

        while (left < right) {
            if (left == index) left++; 
            if (right == index) right--; 

            if (left >= right) break;

            int sum = A[left] + A[right];

            if (sum == target) {
                return true; 
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return false;
    }
}
