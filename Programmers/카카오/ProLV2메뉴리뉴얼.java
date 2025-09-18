import java.util.*;
class Solution {
    Map<String, Integer> countMap;
    
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        for (int size : course) {
            countMap = new HashMap<>();
            for (String order : orders) {
                char[] arr = order.toCharArray();
                Arrays.sort(arr);
                makeCombination(arr, new StringBuilder(), 0, size);
            }
            int maxCount = 0;
            for (int val : countMap.values()) {
                maxCount = Math.max(maxCount, val);
            }
            if (maxCount >= 2) {
                for (String key : countMap.keySet()) {
                    if (countMap.get(key) == maxCount) {
                        answer.add(key);
                    }
                }
            }
        }
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
    
    private void makeCombination(char[] arr, StringBuilder sb, int idx, int target) {
        if (sb.length() == target) {
            countMap.put(sb.toString(), countMap.getOrDefault(sb.toString(), 0) + 1);
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            sb.append(arr[i]);
            makeCombination(arr, sb, i + 1, target);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}