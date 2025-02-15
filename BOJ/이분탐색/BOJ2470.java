import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int temp = Integer.MAX_VALUE;
        int left = 0;
        int right = n - 1;
        int resultR = 0;
        int resultL = 0;
        while(left < right){
            int cnt = arr[left] + arr[right];
            if(temp > Math.abs(cnt)){
                temp = Math.abs(cnt);
                resultL = arr[left];
                resultR = arr[right];
            }
            if(cnt == 0) break;
            else if(cnt > 0) right--;
            else left++;
            
        }

        System.out.println(resultL + " " + resultR);
    }
}
