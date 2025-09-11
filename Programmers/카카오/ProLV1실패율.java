import java.util.*;

class Solution {
    class Stage {
        int idx;
        double rate;

        Stage(int idx, double rate) {
            this.idx = idx;
            this.rate = rate;
        }
    }

    public int[] solution(int N, int[] stages) {
        List<Stage> l = new ArrayList<>();
        
        for (int i = 1; i <= N; i++) {
            int total = 0;
            int fall = 0;

            for (int j = 0; j < stages.length; j++) {
                if (stages[j] >= i) {
                    total++;
                }
                if (stages[j] == i) {
                    fall++;
                }
            }

            double failureRate = 0.0;
            if (total != 0) {
                failureRate = (double) fall / total;
            }
            
            l.add(new Stage(i, failureRate));
        }

        Collections.sort(l, (a, b) -> Double.compare(b.rate, a.rate));

        int[] answer = new int[l.size()];
        for (int i = 0; i < l.size(); i++) {
            answer[i] = l.get(i).idx;
        }
        return answer;
    }
}