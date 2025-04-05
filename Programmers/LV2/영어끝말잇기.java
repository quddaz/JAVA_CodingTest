import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        Map<String, Integer> m = new HashMap<>();
        m.put(words[0], 0);
        
        String target = words[0];
        for(int i = 1; i < words.length; i++){
            if(!m.containsKey(words[i]) && target.charAt(target.length() - 1) == words[i].charAt(0)){
                target = words[i];
                m.put(words[i], 0);
            }else{
                return new int[] {(i % n) + 1, i/n + 1};
            }
        }
        return new int[] {0,0};
    }
}