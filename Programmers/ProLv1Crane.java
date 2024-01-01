import java.util.ArrayList;

class Solution {
    public int solution(int[][] board, int[] moves) {
        ArrayList<Integer> al = new ArrayList<>(); //크레인으로 집은 것들을 넣는 바구니
        int answer = 0;

        for (Integer move : moves) {
            move -= 1; // -1을 해줘야 배열에 대한 순서가 맞다.
            for (int i = 0; i < board.length; i++) {
                if (board[i][move] != 0) {
                    if (!al.isEmpty() && board[i][move] == al.get(al.size() - 1)) {
                        answer += 2;
                        al.remove(al.size() - 1);
                    } else {
                        al.add(board[i][move]);
                    }
                    board[i][move] = 0;
                    break;
                }
            }
        }

        return answer;
    }
}