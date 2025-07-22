import java.io.*;
import java.util.*;

public class Main {
    static class homework{
        int day;
        int distance;

        homework(int day, int distance){
            this.day = day;
            this.distance = distance;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<homework> li = new ArrayList<>();

        int maxDay = 0;
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            li.add(new homework(day, distance));

            maxDay = Math.max(maxDay, day);
        }

        li.sort((a, b) -> b.day - a.day);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int result = 0;
        int idx = 0;

        for (int today = maxDay; today >= 1; today--) {
            while (idx < n && li.get(idx).day >= today) {
                pq.add(li.get(idx).distance);
                idx++;
            }

            if (!pq.isEmpty()) {
                result += pq.poll(); 
            }
        }

        System.out.println(result);
    }
}
