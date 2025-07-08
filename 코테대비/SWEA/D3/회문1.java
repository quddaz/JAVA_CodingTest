import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
 
        for (int testCase = 1; testCase <= 10; testCase++) {
            int palindromeLength = Integer.parseInt(reader.readLine());
            char[][] board = new char[8][8];
             
            // 8x8 글자판을 입력 받기
            for (int i = 0; i < 8; i++) {
                board[i] = reader.readLine().toCharArray();
            }
             
            int palindromeCount = 0;
             
            // 가로 방향 회문 찾기
            for (int row = 0; row < 8; row++) {
                for (int start = 0; start <= 8 - palindromeLength; start++) {
                    if (isPalindrome(board, row, start, palindromeLength, true)) {
                        palindromeCount++;
                    }
                }
            }
             
            // 세로 방향 회문 찾기
            for (int col = 0; col < 8; col++) {
                for (int start = 0; start <= 8 - palindromeLength; start++) {
                    if (isPalindrome(board, start, col, palindromeLength, false)) {
                        palindromeCount++;
                    }
                }
            }
             
            System.out.println("#" + testCase + " " + palindromeCount);
        }
    }
     
    // 회문 검사 함수
    private static boolean isPalindrome(char[][] board, int row, int col, int length, boolean isHorizontal) {
        for (int i = 0; i < length / 2; i++) {
            char startChar = isHorizontal ? board[row][col + i] : board[row + i][col];
            char endChar = isHorizontal ? board[row][col + length - 1 - i] : board[row + length - 1 - i][col];
            if (startChar != endChar) {
                return false;
            }
        }
        return true;
    }
}