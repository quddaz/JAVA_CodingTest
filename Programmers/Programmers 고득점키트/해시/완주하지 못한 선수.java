import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hm = new HashMap<>();
        for (String par : participant) {
            hm.put(par, hm.getOrDefault(par, 0) + 1);
        }
        for (String compl : completion) {
            hm.put(compl, hm.get(compl) - 1);
        }

        for (Map.Entry<String, Integer> entry : hm.entrySet()) {
            if (entry.getValue() > 0) {
                return entry.getKey();
            }
        }

        return null;
    }
}