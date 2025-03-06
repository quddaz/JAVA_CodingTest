import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Map<Integer, Integer> m = new HashMap<>();
        for(int i = 1; i <= n; i++){
            m.put(i, 1);
        }
        
        for(int num : lost){
            m.put(num, m.get(num) - 1);
        }
        
        for(int num : reserve){
            m.put(num, m.get(num) + 1);
        }
        
        for(int i = 1; i <= n; i++){
            if(m.get(i) < 1){
                if(i != 1 && m.get(i - 1) == 2){
                    m.put(i - 1, 1);
                    m.put(i, 1);
                }else if(i != n && m.get(i + 1) == 2){
                    m.put(i + 1, 1);
                    m.put(i, 1);
                }
            }
        }
        
        int result = 0;
        for(int num : m.values()){
            if(num > 0)
                result++;
        }
        return result;
    }
}