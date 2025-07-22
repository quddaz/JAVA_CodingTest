import java.io.*;
import java.util.*;

public class Main {

    static class solve{
        int line;
        int cup;

        solve(int line, int cup){
            this.line = line;
            this.cup = cup;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<solve> li = new ArrayList<>();
        int maxLine = 0;
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int line = Integer.parseInt(st.nextToken());
            int cup = Integer.parseInt(st.nextToken());
            li.add(new solve(line, cup));
            maxLine = Math.max(maxLine, line);
        }

        li.sort((a,b)-> b.line - a.line);
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        int idx = 0;
        int result = 0;

        for(int today = maxLine; today >= 1; today--){
            while(idx < n && li.get(idx).line >= today){
                q.add(li.get(idx).cup);
                idx++;
            }

            if(!q.isEmpty()){
                result += q.poll();
            }
        }
        System.out.println(result);
    }
}
