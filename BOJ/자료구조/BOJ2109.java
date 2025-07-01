import java.io.*;
import java.util.*;

public class Main {
    static class Lecture {
        int pay;
        int day;
        Lecture(int pay, int day) {
            this.pay = pay;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Lecture> lectures = new ArrayList<>();
        int maxDay = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int pay = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            lectures.add(new Lecture(pay, day));
            maxDay = Math.max(maxDay, day);
        }
        lectures.sort((a, b) -> b.day - a.day);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int result = 0;
        int idx = 0;

        for (int day = maxDay; day >= 1; day--) {
            while (idx < lectures.size() && lectures.get(idx).day >= day) {
                pq.offer(lectures.get(idx).pay);
                idx++;
            }
            if (!pq.isEmpty()) {
                result += pq.poll();
            }
        }

        System.out.println(result);
    }
}
