import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2);
        
        String[] parts = s.split("\\},\\{");
        
        List<List<Integer>> list = new ArrayList<>();
        for (String part : parts) {
            String[] nums = part.split(",");
            List<Integer> arr = new ArrayList<>();
            for (String num : nums) {
                arr.add(Integer.parseInt(num));
            }
            list.add(arr);
        }
        Collections.sort(list, (a, b) -> a.size() - b.size());
        
        List<Integer> result = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        for (List<Integer> arr : list) {
            for (int num : arr) {
                if (!seen.contains(num)) {
                    result.add(num);
                    seen.add(num);
                }
            }
        }
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}