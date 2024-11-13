import java.util.HashMap;
class Solution {
    public int[] solution(String s) {
        int[] result = new int[s.length()];
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i <s.length();i++){
            if(map.containsKey(s.charAt(i))){
                result[i] = i-map.get(s.charAt(i));
                map.put(s.charAt(i),i);
            }
            else{
                map.put(s.charAt(i),i);
                result[i] = -1;
            }
        }

        return result;
    }
}