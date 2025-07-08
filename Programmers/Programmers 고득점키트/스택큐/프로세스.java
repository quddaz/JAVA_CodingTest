import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        int[] sortedPriorities = priorities.clone();
        Arrays.sort(sortedPriorities);

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new int[] {priorities[i], i});
        }

        int printOrder = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentPriority = current[0];
            int currentIndex = current[1];

            if (currentPriority == sortedPriorities[sortedPriorities.length - 1 - printOrder]) {
                printOrder++;
                if (currentIndex == location) {
                    return printOrder;
                }
            } else {
                queue.add(current);
            }
        }
        return -1;
    }
}