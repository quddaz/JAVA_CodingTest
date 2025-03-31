class Solution {
    public int solution(int n) {
        int MOD = 1234567;
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        int a = 1, b = 2, result = 0;
        for (int i = 3; i <= n; i++) {
            result = (a + b) % MOD;
            a = b;
            b = result;
        }
        return result;
    }
}