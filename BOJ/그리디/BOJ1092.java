import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        List<Integer> box = new ArrayList<>();
        for(int i = 0; i < m; i++){
            box.add(Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr);
        box.sort(Collections.reverseOrder());

        if(arr[n-1] < box.get(0)){
            System.out.println(-1);
            return;
        }

        int time = 0;
        while(!box.isEmpty()){
            int idx = 0; //박스 인덱스 
            for(int i = n - 1; i >= 0; i--){
                if(idx >= box.size()) break;
                if(arr[i] >= box.get(idx)) box.remove(idx);
                else{
                    idx++;
                    i++;
                }
            }
            time++;
        }

        if(!box.isEmpty()){
            System.out.println(-1);
        }else
            System.out.println(time);
    }
}
