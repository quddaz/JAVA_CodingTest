import java.util.*;

class Solution {
    static int[] answer = {-1};
    static int maxDiff = 0;

    public int[] solution(int n, int[] info) {
        dfs(0, n, new int[11], info);
        return answer;
    }

    static void dfs(int idx, int arrows, int[] ryan, int[] apeach) {
        if (idx == 11) {
            if (arrows > 0) ryan[10] += arrows;

            int ryanScore = 0, apeachScore = 0;
            for (int i = 0; i < 11; i++) {
                if (ryan[i] == 0 && apeach[i] == 0) continue;
                if (ryan[i] > apeach[i]) ryanScore += (10 - i);
                else apeachScore += (10 - i);
            }

            int diff = ryanScore - apeachScore;
            if (diff > 0) {
                if (diff > maxDiff) {
                    maxDiff = diff;
                    answer = ryan.clone();
                } else if (diff == maxDiff) {
                    for (int i = 10; i >= 0; i--) {
                        if (ryan[i] > answer[i]) {
                            answer = ryan.clone();
                            break;
                        } else if (ryan[i] < answer[i]) {
                            break;
                        }
                    }
                }
            }

            if (arrows > 0) ryan[10] -= arrows;
            return;
        }

        if (arrows > apeach[idx]) {
            ryan[idx] = apeach[idx] + 1;
            dfs(idx + 1, arrows - ryan[idx], ryan, apeach);
            ryan[idx] = 0;
        }

        dfs(idx + 1, arrows, ryan, apeach);
    }
}