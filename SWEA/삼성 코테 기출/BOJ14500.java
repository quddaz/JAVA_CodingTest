import java.io.*;
import java.util.*;

public class Main {
    static int N, M, maxSum = 0;
    static int[][] map;
    
    static int[][][] baseTetrominoes = {
        {{0,0}, {0,1}, {0,2}, {0,3}},  // ㅡ 자
        {{0,0}, {1,0}, {2,0}, {3,0}},  // ㅣ 자
        {{0,0}, {0,1}, {1,0}, {1,1}},  // ㅁ 자
        {{0,0}, {1,0}, {2,0}, {2,1}},  // L 자
        {{0,0}, {0,1}, {0,2}, {1,1}},  // ㅗ 자
        {{0,0}, {0,1}, {1,1}, {1,2}}   // Z 자
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        findMaxTetromino();
        System.out.println(maxSum);
    }

    public static void findMaxTetromino() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int[][] tetromino : generateTetrominoes()) {
                    int sum = 0;
                    boolean isValid = true;
                    for (int[] block : tetromino) {
                        int x = i + block[0];
                        int y = j + block[1];
                        if (x < 0 || x >= N || y < 0 || y >= M) {
                            isValid = false;
                            break;
                        }
                        sum += map[x][y];
                    }
                    if (isValid) maxSum = Math.max(maxSum, sum);
                }
            }
        }
    }

    public static List<int[][]> generateTetrominoes() {
        List<int[][]> allTetrominoes = new ArrayList<>();
        for (int[][] base : baseTetrominoes) {
            for (int r = 0; r < 4; r++) { 
                base = rotateTetromino(base);
                allTetrominoes.add(base);
                allTetrominoes.add(reflectTetromino(base));
            }
        }
        return allTetrominoes;
    }

    public static int[][] rotateTetromino(int[][] tetromino) {
        int[][] rotated = new int[4][2];
        for (int i = 0; i < 4; i++) {
            rotated[i][0] = tetromino[i][1];  // x = y'
            rotated[i][1] = -tetromino[i][0]; // y = -x'
        }
        return normalize(rotated);
    }

    public static int[][] reflectTetromino(int[][] tetromino) {
        int[][] reflected = new int[4][2];
        for (int i = 0; i < 4; i++) {
            reflected[i][0] = tetromino[i][0]; // x = x
            reflected[i][1] = -tetromino[i][1];  // y = -y
        }
        return normalize(reflected);
    }

    public static int[][] normalize(int[][] tetromino) {
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        for (int[] block : tetromino) {
            minX = Math.min(minX, block[0]);
            minY = Math.min(minY, block[1]);
        }
        int[][] normalized = new int[4][2];
        for (int i = 0; i < 4; i++) {
            normalized[i][0] = tetromino[i][0] - minX;
            normalized[i][1] = tetromino[i][1] - minY;
        }
        return normalized;
    }
}
