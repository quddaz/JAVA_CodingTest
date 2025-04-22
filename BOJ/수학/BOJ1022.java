import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        int rows = r2 - r1 + 1;
        int cols = c2 - c1 + 1;

        int[][] map = new int[rows][cols];
        int maxVal = 0;

        // map 채우기 + 최대값 추출
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int val = getValue(r1 + i, c1 + j);
                map[i][j] = val;
                maxVal = Math.max(maxVal, val);
            }
        }

        // 최대 숫자 길이
        int width = Integer.toString(maxVal).length();
        StringBuilder sb = new StringBuilder();

        // 출력
        for (int[] row : map) {
            for (int num : row) {
                sb.append(String.format("%" + width + "d ", num));
            }
            sb.setLength(sb.length() - 1); // 마지막 공백 제거
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static int getValue(int r, int c) {
        int layer = Math.max(Math.abs(r), Math.abs(c));
        int len = 2 * layer + 1;
        int max = len * len;

        if (r == layer) return max - (layer - c);
        max -= len - 1;
        if (c == -layer) return max - (layer - r);
        max -= len - 1;
        if (r == -layer) return max - (c + layer);
        max -= len - 1;
        return max - (r + layer);
    }
}
