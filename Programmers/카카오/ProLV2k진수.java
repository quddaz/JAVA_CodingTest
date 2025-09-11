class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String convertedNum = Integer.toString(n, k);
        String[] candidates = convertedNum.split("0");
        
        for (String s : candidates) {
            if (s.equals("")) {
                continue;
            }
            
            long num = Long.parseLong(s);
            
            if (isPrime(num)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean isPrime(long num) {
        if (num < 2) {
            return false;
        }
        
        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}