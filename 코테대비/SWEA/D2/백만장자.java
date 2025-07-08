import java.util.*;
import java.io.*;
 
class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            long result = 0;
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
 
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
 
            int max = arr[N - 1];
            for (int j = N - 2; j >= 0; j--) {
                if (arr[j] < max) {
                    result += max - arr[j];
                } else {
                    max = arr[j];
                }
            }
            System.out.println("#" + i + " " + result);
        }
    }
}