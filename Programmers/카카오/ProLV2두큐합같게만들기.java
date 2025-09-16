import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int n = queue1.length;
        long sum1 = 0, sum2 = 0;
        
        for (int q : queue1) sum1 += q;
        for (int q : queue2) sum2 += q;
        
        long total = sum1 + sum2;
        if (total % 2 != 0) return -1; 
        long target = total / 2;
        
        int[] arr = new int[2 * n];
        System.arraycopy(queue1, 0, arr, 0, n);
        System.arraycopy(queue2, 0, arr, n, n);
        
        int p1 = 0, p2 = n; 
        int maxOps = n * 4; 
        int ops = 0;
        
        while (ops <= maxOps) {
            if (sum1 == target) return ops;
            
            if (sum1 > target) {
                sum1 -= arr[p1 % (2 * n)];
                p1++;
            } else {
                sum1 += arr[p2 % (2 * n)];
                p2++;
            }
            ops++;
        }
        return -1;
    }
}
