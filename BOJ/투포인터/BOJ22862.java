import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int arr[] = new int[s];
        
        for(int i = 0; i < s; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        int result = -1;
        int end = 0;
        int start = 0;

        if(arr[0] % 2 == 1)
            count++;

        while(start < s){
            if(end == s - 1){
                result = Math.max(result, end - start + 1 - count);
                break;
            }

            if(count == k){
                if(arr[end+1] % 2 == 1){
                    result = Math.max(result, end - start + 1 - count);
                    if(arr[start] % 2 == 1)
                        count--;
                    start++;
                }else{
                    end++;
                }
            }else{
                if(arr[end+1] % 2 == 1) count++;
                end++;
            }
        }

        System.out.println(result);

    }
}
