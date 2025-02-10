import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> li = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            int num = -(Integer.parseInt(st.nextToken()));
            int pos = Collections.binarySearch(li, num);
            if(pos < 0) pos = -pos - 1;
            if(pos == li.size()) li.add(num);
            else li.set(pos, num);
        }

        System.out.println(li.size());
    }

}
