class Solution {
    int[] answer = new int[2];

    public int[] solution(int[][] arr) {
        compress(arr, 0, 0, arr.length);
        return answer;
    }

    void compress(int[][] arr, int row, int col, int size) {
        if (isSame(arr, row, col, size)) {
            answer[arr[row][col]]++;
            return;
        }

        int half = size / 2;
        compress(arr, row, col, half);
        compress(arr, row, col + half, half);
        compress(arr, row + half, col, half);
        compress(arr, row + half, col + half, half);
    }

    boolean isSame(int[][] arr, int row, int col, int size) {
        int val = arr[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (arr[i][j] != val) return false;
            }
        }
        return true;
    }
}