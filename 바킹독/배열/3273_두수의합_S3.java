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

        int answer = 0;
        int target = Integer.parseInt(br.readLine());
        int left = 0;
        int right = n - 1;
        while(left < right){
            if(arr[left] + arr[right] == target){
                answer++;
                left++;
            }else if(arr[left] + arr[right] < target){
                left++;
            }else{
                right--;
            }
        }

        System.out.println(answer);
    }
}