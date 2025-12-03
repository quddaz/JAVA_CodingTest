class Solution {
    public int solution(String[] arr) {
        int n = (arr.length + 1) / 2; // 숫자의 개수
        int[][] maxDp = new int[n][n];
        int[][] minDp = new int[n][n];

        for (int i = 0; i < n; i++) {
            maxDp[i][i] = minDp[i][i] = Integer.parseInt(arr[i * 2]);
        }

        for (int length = 2; length <= n; length++) { 
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                maxDp[i][j] = Integer.MIN_VALUE;
                minDp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    char op = arr[k * 2 + 1].charAt(0); 
                    int leftMax = maxDp[i][k], leftMin = minDp[i][k];
                    int rightMax = maxDp[k + 1][j], rightMin = minDp[k + 1][j];

                    if (op == '+') {
                        maxDp[i][j] = Math.max(maxDp[i][j], leftMax + rightMax);
                        minDp[i][j] = Math.min(minDp[i][j], leftMin + rightMin);
                    } else { // '-'
                        maxDp[i][j] = Math.max(maxDp[i][j], leftMax - rightMin);
                        minDp[i][j] = Math.min(minDp[i][j], leftMin - rightMax);
                    }
                }
            }
        }
        return maxDp[0][n - 1];
    }
}
