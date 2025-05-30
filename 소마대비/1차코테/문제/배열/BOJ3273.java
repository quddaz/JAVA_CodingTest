import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);

        int x = Integer.parseInt(br.readLine());


        int left = 0;
        int right = n - 1;
        int count = 0;
        while(left < right){
            int cnt = arr[left] + arr[right];
            if(cnt > x){
                right--;
            }else if(cnt < x){
                left++;
            }else{
                left++;
                count++;
            }
        }

        System.out.println(count);
    }
}