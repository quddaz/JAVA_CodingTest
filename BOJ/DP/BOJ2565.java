import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int arr[][] = new int[n][2];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (a,b) -> a[0] - b[0]);

        List<Integer> li = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int idx = Collections.binarySearch(li, arr[i][1]);

            if(idx < 0){
                idx = -(idx + 1);
            }
            
            if(idx == li.size()){
                li.add(arr[i][1]);
            } else {
                li.set(idx, arr[i][1]); 
            }
        }

        System.out.println(n - li.size());
    }
}
