import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> m = new HashMap<>();
        
        
        for(String[] clothe : clothes){
            m.put(clothe[1], m.getOrDefault(clothe[1],0) + 1);
        }
        
        int answer = 1;
        for(int count : m.values()){
            answer *= count + 1;
        }
        
        return answer - 1;
    }
}