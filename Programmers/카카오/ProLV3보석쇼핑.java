import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        Set<String> set = new HashSet<>(List.of(gems));
        
        int start = 0;
        int end = 0;
        int minLength = gems.length  + 1;
        Map<String, Integer> map = new HashMap<>();
        while(end < gems.length){
            map.put(gems[end], map.getOrDefault(gems[end],0) + 1);
            end++;
            
            while(map.size() == set.size()){
                if(end - start < minLength){
                    minLength = end - start;
                    answer[0] = start + 1;
                    answer[1] = end;
                }
                
                map.put(gems[start], map.get(gems[start]) - 1);
                if (map.get(gems[start]) == 0) {
                    map.remove(gems[start]);
                }
                start++;
            }
        }
        return answer;
    }
}