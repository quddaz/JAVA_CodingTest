class Solution {
    public int[] solution(int[] sequence, int k) {
        int start = 0;
        int end = 0;
        int max = 1000001;
        int total = 0;
        int result[] = new int[2];
        
        while(end < sequence.length){
           total += sequence[end];
           end++;
            while(total > k && start < end){
                total -= sequence[start];
                start++;
            }
            
            if(total == k && end - start < max){
                result[0] = start;
                result[1] = end-1;
                max = end - start;
            }
        }
        return new int[] {result[0], result[1]};
    }

}