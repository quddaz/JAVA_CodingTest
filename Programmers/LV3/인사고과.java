import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int n = scores.length;
        int[] wanho = scores[0];

        Arrays.sort(scores, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });

        int maxPeer = 0;
        List<int[]> candidates = new ArrayList<>();
        for (int[] score : scores) {
            if (score[1] >= maxPeer) {
                candidates.add(score);
                maxPeer = Math.max(maxPeer, score[1]);
            }
        }

        boolean found = false;
        for (int[] score : candidates) {
            if (score[0] == wanho[0] && score[1] == wanho[1]) {
                found = true;
                break;
            }
        }
        if (!found) return -1;

        candidates.sort((a, b) -> (b[0] + b[1]) - (a[0] + a[1]));

        int rank = 1;
        int prevSum = -1;
        int count = 0; 
        for (int[] score : candidates) {
            int sum = score[0] + score[1];
            if (sum != prevSum) {
                rank += count;
                count = 1;
                prevSum = sum;
            } else {
                count++;
            }
            if (score[0] == wanho[0] && score[1] == wanho[1]) {
                return rank;
            }
        }

        return -1;
    }
}
