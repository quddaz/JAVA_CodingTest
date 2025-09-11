import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> m1 = getMap(str1.toLowerCase());
        Map<String, Integer> m2 = getMap(str2.toLowerCase());
        if (m1.isEmpty() && m2.isEmpty()) return 65536;

        int inter = 0;
        int union = 0;

        Set<String> all = new HashSet<>();
        all.addAll(m1.keySet());
        all.addAll(m2.keySet());

        for (String key : all) {
            int c1 = m1.getOrDefault(key, 0);
            int c2 = m2.getOrDefault(key, 0);
            inter += Math.min(c1, c2);
            union += Math.max(c1, c2);
        }

        double jaccard = (double) inter / union;
        return (int) (jaccard * 65536);
        
    }
    
    public static Map<String, Integer> getMap(String str){
        Map<String, Integer> m = new HashMap<>();
        for(int i = 0; i < str.length() -1 ;i++){
            String cnt = str.substring(i, i + 2);
            boolean flag = false;
            for(int j = 0; j < cnt.length(); j++){
                char c = cnt.charAt(j);
                if((int)c < 97 || (int)c > 122){
                    flag = true;
                    break;
                }
            }
            if(!flag) m.put(cnt, m.getOrDefault(cnt, 0) + 1);
        }
        return m;
    }
}