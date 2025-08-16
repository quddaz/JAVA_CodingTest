import java.io.*;
import java.util.*;

public class Main {
    static int r, c, k;
    static int[][] A = new int[101][101]; 
    static int rowSize = 3, colSize = 3; 

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        while (time <= 100) {
            if (A[r - 1][c - 1] == k) {
                System.out.println(time);
                return;
            }

            if (rowSize >= colSize) {
                R();
            } else {
                C();
            }
            time++;
        }
        System.out.println(-1);
    }

    static void R() {
        int newColSize = 0;
        for (int i = 0; i < rowSize; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < colSize; j++) {
                if (A[i][j] == 0) continue;
                map.put(A[i][j], map.getOrDefault(A[i][j], 0) + 1);
            }

            List<int[]> list = new ArrayList<>();
            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                list.add(new int[]{e.getKey(), e.getValue()});
            }

            list.sort((a, b) -> {
                if (a[1] == b[1]) return a[0] - b[0];
                return a[1] - b[1];
            });

            int idx = 0;
            for (int[] pair : list) {
                if (idx >= 100) break; 
                A[i][idx++] = pair[0];
                if (idx >= 100) break;
                A[i][idx++] = pair[1];
            }

            newColSize = Math.max(newColSize, idx);
            for (int j = idx; j < 100; j++) {
                A[i][j] = 0;
            }
        }
        colSize = newColSize;
    }

    static void C() {
        int newRowSize = 0;
        for (int j = 0; j < colSize; j++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < rowSize; i++) {
                if (A[i][j] == 0) continue;
                map.put(A[i][j], map.getOrDefault(A[i][j], 0) + 1);
            }

            List<int[]> list = new ArrayList<>();
            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                list.add(new int[]{e.getKey(), e.getValue()});
            }

            list.sort((a, b) -> {
                if (a[1] == b[1]) return a[0] - b[0];
                return a[1] - b[1];
            });

            int idx = 0;
            for (int[] pair : list) {
                if (idx >= 100) break;
                A[idx++][j] = pair[0];
                if (idx >= 100) break;
                A[idx++][j] = pair[1];
            }

            newRowSize = Math.max(newRowSize, idx);
            for (int i = idx; i < 100; i++) {
                A[i][j] = 0;
            }
        }
        rowSize = newRowSize;
    }
}
