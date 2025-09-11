import java.util.*;
class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder fullSequence = new StringBuilder();

        int num = 0;
        while (fullSequence.length() < t * m) {
            fullSequence.append(Integer.toString(num, n).toUpperCase());
            num++;
        }
        
        StringBuilder answer = new StringBuilder();
        
        for (int i = 0; i < t; i++) {
            int tubeIndex = (p - 1) + (i * m);
            answer.append(fullSequence.charAt(tubeIndex));
        }
        
        return answer.toString();
    }

}