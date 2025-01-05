import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());

        long arr1[] = new long[n1];
        long arr2[] = new long[n2];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n1; i++){
            arr1[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n2; i++){
            arr2[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr1); 
        Arrays.sort(arr2); 

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i = 0; i < n1; i++){
            if(!search(arr1[i], arr2)){
                count++;
                sb.append(arr1[i]).append(" ");
            }
        }

        System.out.println(count);
        System.out.println(sb);
    }

    public static boolean search(long num, long[] arr){
        int left = 0;
        int right = arr.length - 1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(num == arr[mid])
                return true;
            else if(arr[mid] < num)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }
}
