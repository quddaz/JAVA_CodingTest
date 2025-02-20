import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> m = new HashMap<>();
        
        for(String p : participant){
            m.put(p, m.getOrDefault(p, 0) + 1);
        }
        
        
        for(String com : completion){
            m.put(com, m.get(com) - 1);
            m.remove(com,0);
        }
        
        for(String p : m.keySet()){
            if(m.get(p) != 0){
                return p;
            }
        }
        
        
        return "";
    }
}