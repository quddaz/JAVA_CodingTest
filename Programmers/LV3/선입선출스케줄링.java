class Solution {
    public int solution(int n, int[] cores) {
        int left = 0;
        int right = 500000000;
        int time = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            long workDone = cores.length;
            for (int core : cores) {
                workDone += (mid / core);
            }

            if (workDone >= n) {
                time = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        long workDone = cores.length;
        for (int core : cores) {
            workDone += ((time - 1) / core);
        }

        for (int i = 0; i < cores.length; i++) {
            if (time % cores[i] == 0) {
                workDone++;
                if (workDone == n) return i + 1;
            }
        }

        return -1;
    }
}