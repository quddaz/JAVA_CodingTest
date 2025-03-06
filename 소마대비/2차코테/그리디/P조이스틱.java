import java.util.Arrays;

class Solution {
    public int solution(String name) {
        int length = name.length();
        int move = length - 1;
        
        int result = 0;
        for(int i = 0; i < length; i++){
            result += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            
            int next = i + 1;
            while(next < length && name.charAt(next) == 'A'){
                next++;
            }
            
            move = Math.min(move, (i * 2) + (length - next));
            move = Math.min(move, (length - next) * 2 + i);
        }
        
        result += move;
        return result;
    }
}
