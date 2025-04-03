import java.util.*;

class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        int[] num = {4, 1, 2}; // 124나라 숫자
        
        while (n > 0) {
            int remainder = n % 3;
            n = (n - 1) / 3; 
            
            answer.insert(0, num[remainder]);
        }
        
        return answer.toString();
    }
}