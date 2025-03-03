import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        

        List<Integer> lis = new ArrayList<>();

        for(int i = 0; i < n; i++){
            int cnt = Integer.parseInt(st.nextToken());

            int pos = Collection.binarySearch(lis, cnt);

            if(pos < 0) pos = -(pos + 1);


            if(pos == lis.size()){
                lis.add(cnt);
            }else{
                lis.set(pos, cnt);
            }
        }

        System.out.println(lis.size());
    }
}
