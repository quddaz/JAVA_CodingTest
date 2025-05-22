import java.util.*;

class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] result = new int[balls.length];

        for (int i = 0; i < balls.length; i++) {
            int targetX = balls[i][0];
            int targetY = balls[i][1];

            int minDistSq = Integer.MAX_VALUE;

            // 아래쪽 반사
            if (!(startX == targetX && startY > targetY)) {
                int dx = startX - targetX;
                int dy = startY - (-targetY);
                minDistSq = Math.min(minDistSq, dx * dx + dy * dy);
            }

            // 위쪽 반사
            if (!(startX == targetX && startY < targetY)) {
                int dx = startX - targetX;
                int dy = startY - (2 * n - targetY);
                minDistSq = Math.min(minDistSq, dx * dx + dy * dy);
            }

            // 왼쪽 반사
            if (!(startY == targetY && startX > targetX)) {
                int dx = startX - (-targetX);
                int dy = startY - targetY;
                minDistSq = Math.min(minDistSq, dx * dx + dy * dy);
            }

            // 오른쪽 반사
            if (!(startY == targetY && startX < targetX)) {
                int dx = startX - (2 * m - targetX);
                int dy = startY - targetY;
                minDistSq = Math.min(minDistSq, dx * dx + dy * dy);
            }

            result[i] = minDistSq;
        }

        return result;
    }
}
