class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i <= right; i++){
            if(countDivisors(i)%2 == 0)
                answer += i;
            else
                answer -= i;
        }
        return answer;
    }
    public static int countDivisors(int n) {
        int count = 1;

        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                int exponent = 0;
                while (n % i == 0) {
                    n /= i;
                    exponent++;
                }
                count *= (exponent + 1);
            }
        }

        return count;
    }
}