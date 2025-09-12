import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dict = new HashMap<>();
        int idx = 1;
        for (char c = 'A'; c <= 'Z'; c++) {
            dict.put(String.valueOf(c), idx++);
        }

        List<Integer> result = new ArrayList<>();
        int i = 0;
        while (i < msg.length()) {
            String w = "" + msg.charAt(i);
            int j = i + 1;
            while (j <= msg.length() && dict.containsKey(msg.substring(i, j))) {
                w = msg.substring(i, j);
                j++;
            }
            result.add(dict.get(w));
            if (j <= msg.length()) {
                String wc = msg.substring(i, j);
                dict.put(wc, idx++);
            }
            i += w.length();
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
