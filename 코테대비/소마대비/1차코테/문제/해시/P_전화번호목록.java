import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        Map<String, Integer> m = new HashMap<>();
        
        for(String tel : phone_book){
            m.put(tel, m.getOrDefault(tel, 0) + 1);
        }
        
        for(String tel : phone_book){
            for(int i = 1; i < tel.length(); i++){
                if(m.containsKey(tel.substring(0,i)))
                    return false;
            }
        }
        
        return true;
    }
}