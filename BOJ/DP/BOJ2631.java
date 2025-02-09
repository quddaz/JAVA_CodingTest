import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        List<Integer> li = new ArrayList<>();
        for(int num : arr){
            int cnt = Collections.binarySearch(li, num);
            if(cnt < 0) cnt = -cnt - 1;
            if(cnt == li.size()) li.add(num);
            else li.set(cnt, num);
        }
        
        System.out.println(n - li.size());
    }
}
