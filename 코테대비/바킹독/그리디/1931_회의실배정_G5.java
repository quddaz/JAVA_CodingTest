import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<int[]> li = new ArrayList<>();

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            li.add(new int[]{start,end});
        }

        Collections.sort(li, (a,b)->{
            if(a[1] == b[1])
                return a[0] - b[0];
            return a[1] - b[1];
        });

        int end = 0;
        int answer = 0;
        for(int i = 0; i < n; i++){
            if(li.get(i)[0] >= end){
                answer++;
                end = li.get(i)[1];
            }
        }
        System.out.println(answer);
    }
}