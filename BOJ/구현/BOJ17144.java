import java.io.*;
import java.util.*;

public class Main {
    static int R, C, T;
    static int[][] map;
    static int cleanerTop, cleanerBottom;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        
        map = new int[R][C];
        cleanerTop = -1;
        
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    if (cleanerTop == -1) cleanerTop = i;
                    else cleanerBottom = i;
                }
            }
        }
        
        while (T-- > 0) {
            spreadDust();
            operatePurifier();
        }
        
        System.out.println(getTotalDust());
    }
    
    static void spreadDust() {
        int[][] newMap = new int[R][C];
        
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) {
                    int spreadAmount = map[i][j] / 5;
                    int spreadCount = 0;
                    
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        
                        if (nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] != -1) {
                            newMap[nx][ny] += spreadAmount;
                            spreadCount++;
                        }
                    }
                    newMap[i][j] += map[i][j] - spreadAmount * spreadCount;
                }
            }
        }
        
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == -1) newMap[i][j] = -1;
            }
        }
        
        map = newMap;
    }
    
    static void operatePurifier() {
        // 위쪽 공기청정기: 반시계 방향
        for (int i = cleanerTop - 1; i > 0; i--) map[i][0] = map[i - 1][0];
        for (int j = 0; j < C - 1; j++) map[0][j] = map[0][j + 1];
        for (int i = 0; i < cleanerTop; i++) map[i][C - 1] = map[i + 1][C - 1];
        for (int j = C - 1; j > 1; j--) map[cleanerTop][j] = map[cleanerTop][j - 1];
        map[cleanerTop][1] = 0;
        
        // 아래쪽 공기청정기: 시계 방향
        for (int i = cleanerBottom + 1; i < R - 1; i++) map[i][0] = map[i + 1][0];
        for (int j = 0; j < C - 1; j++) map[R - 1][j] = map[R - 1][j + 1];
        for (int i = R - 1; i > cleanerBottom; i--) map[i][C - 1] = map[i - 1][C - 1];
        for (int j = C - 1; j > 1; j--) map[cleanerBottom][j] = map[cleanerBottom][j - 1];
        map[cleanerBottom][1] = 0;
    }
    
    static int getTotalDust() {
        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) sum += map[i][j];
            }
        }
        return sum;
    }
}
