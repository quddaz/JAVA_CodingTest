import java.util.*;

class Solution {
    public int solution(String s) {
        int n = s.length();
        int answer = n; 

        for (int step = 1; step <= n / 2; step++) {
            StringBuilder compressed = new StringBuilder();
            String prev = s.substring(0, step);
            int count = 1;

            for (int j = step; j < n; j += step) {
                String cur = s.substring(j, Math.min(j + step, n));

                if (cur.equals(prev)) {
                    count++;
                } else {
                    if (count > 1) compressed.append(count);
                    compressed.append(prev);

                    prev = cur;
                    count = 1;
                }
            }

            if (count > 1) compressed.append(count);
            compressed.append(prev);

            answer = Math.min(answer, compressed.length());
        }

        return answer;
    }
}
