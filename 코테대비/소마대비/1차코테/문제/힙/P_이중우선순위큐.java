import java.util.*;

public class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> min = new PriorityQueue<>((a,b) -> a - b);
        PriorityQueue<Integer> max = new PriorityQueue<>((a,b) -> b - a);
        
        
        for(String operation : operations){
            String cnt[] = operation.split(" ");
            
            if(cnt[0].equals("I")){
                min.add(Integer.parseInt(cnt[1]));
                max.add(Integer.parseInt(cnt[1]));
            }else{
                if(min.isEmpty() || max.isEmpty()) continue;
                if(cnt[1].equals("1")){
                    min.remove(max.poll());
                }else{
                    max.remove(min.poll());
                }
            }
        }
        int answer[] ={0,0};
        if(!min.isEmpty() && !max.isEmpty()){
            answer[0] = max.poll();
            answer[1] = min.poll();
        }
        
        return answer;
    }
}