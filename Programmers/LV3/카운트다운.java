import java.util.*;
class Solution {
    public int[] solution(int target) {
        int[] dpCount = new int[target + 1];
        int[] dpSingleBull = new int[target + 1];

        for (int i = 1; i <= target; i++) {
            dpCount[i] = Integer.MAX_VALUE;
        }

        List<int[]> scores = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            scores.add(new int[]{i, 1});
            scores.add(new int[]{i * 2, 0});
            scores.add(new int[]{i * 3, 0});
        }
        scores.add(new int[]{50, 1});

        for (int i = 1; i <= target; i++) {
            for (int[] score : scores) {
                int value = score[0];
                int singleOrBull = score[1];

                if (i - value >= 0) {
                    int newCount = dpCount[i - value] + 1;
                    int newSingleBull = dpSingleBull[i - value] + singleOrBull;

                    if (newCount < dpCount[i]) {
                        dpCount[i] = newCount;
                        dpSingleBull[i] = newSingleBull;
                    } else if (newCount == dpCount[i]) {
                        dpSingleBull[i] = Math.max(dpSingleBull[i], newSingleBull);
                    }
                }
            }
        }

        return new int[]{dpCount[target], dpSingleBull[target]};
    }
}