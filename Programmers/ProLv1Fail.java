import java.util.Arrays;
class Solution {
    public int[] solution(int N, int[] stages) {
        Arrays.sort(stages);
        int[] answer = new int[N];
        int MAX = N;
        double[] arr = new double[MAX];
        
        for(int i = 0;i< N ;i++){
            int playersAtStage = 0;
            int playersNotCleared = 0;
            for(int j = 0; j < stages.length;j++){
                if(stages[j] == i+1){
                    playersNotCleared++;
                    playersAtStage++;
                }
                else if(stages[j] > i+1)
                    playersAtStage++;
            }
            arr[i] = (playersNotCleared == 0) ? 0 : (double) playersNotCleared / playersAtStage;
        }
        
        for(int i = 0; i < N;i++){
            int pointer = 0;
            double temp = -1;
            for(int j = 0; j < N ;j++){
                if(arr[j] > temp){
                    temp = arr[j];
                    pointer = j;
                }
            }
            answer[i] = pointer+1; 
            arr[pointer] = -1;
        }
        
        return answer;
    }
}
