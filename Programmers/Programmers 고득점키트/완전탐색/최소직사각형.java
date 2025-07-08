class Solution {
    public int solution(int[][] sizes) {
        for(int i = 0; i < sizes.length;i++){
            if(sizes[i][0] < sizes[i][1]){
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
        }
        int MAX1 = 0;
        int MAX2 = 0;
        for(int i = 0; i <sizes.length;i++){
            MAX1 = Math.max(MAX1,sizes[i][0]);
            MAX2 = Math.max(MAX2,sizes[i][1]);
        }
        return MAX1 * MAX2;
    }
}
