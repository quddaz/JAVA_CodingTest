class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int count = 0;
        int zero = 0;
        for(int i = 0; i < win_nums.length;i++){
            if(lottos[i] == 0)
                zero++;
            else{
                for(Integer num : win_nums){
                    if(lottos[i]== num)
                        count++;
                }
            }
        }
        int[] answer = {Math.min(7-count-zero,6),Math.min(7-count,6)};
        return answer;
    }
}