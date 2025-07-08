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


        List<Integer> li = new ArrayList<>();

        for(int num : arr){
            if(li.isEmpty() || li.get(li.size() - 1) < num){
                li.add(num);
            }else{
                int idx = Collections.binarySearch(li, num);
                if(idx < 0) idx = -(idx + 1);
                li.set(idx, num);
            }
        }

        System.out.println(li.size());
    }
}

