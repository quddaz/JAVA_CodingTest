import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());


        int n = Integer.parseInt(br.readLine());
        int A[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int B[] = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        long result = solution(A, B, T);

        System.out.println(result);
    }
    public static long solution(int[] A, int[] B, int T){
        Map<Integer, Integer> sum_a = new HashMap<>();
        Map<Integer, Integer> sum_b = new HashMap<>(); 
        setMap(A, sum_a);
        setMap(B, sum_b);

        long result = 0;
        for(int sumA : sum_a.keySet()){
            int target = T - sumA;
            if(sum_b.containsKey(target)){
                result += (long) sum_a.get(sumA) * sum_b.get(target);
            }
        }
        return result;
    }
    public static void setMap(int[] arr, Map<Integer, Integer> sum){
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = i; j < n; j++) {
                temp += arr[j];
                sum.put(temp, sum.getOrDefault(temp, 0) + 1);
            }
        }
    }
}
