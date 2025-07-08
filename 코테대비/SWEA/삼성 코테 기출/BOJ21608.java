import java.io.*;
import java.util.*;

public class Main {
    static int map[][];
    static int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static List<Map<Integer, Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        for(int i = 0; i <= n * n; i++){
            graph.add(new HashMap<>());
        }
        for (int i = 0; i < n * n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            Map<Integer, Integer> m = new HashMap<>();

            for (int j = 0; j < 4; j++) {
                graph.get(cnt).put(Integer.parseInt(st.nextToken()), 0);
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                if (a[0] == b[0]) {
                    if (a[1] == b[1]) {
                        if (a[2] == b[2]) return a[3] - b[3]; // 행 작은 순
                        return a[2] - b[2]; // 열 작은 순
                    }
                    return b[1] - a[1]; // 빈 칸 많은 순
                }
                return b[0] - a[0]; // 좋아하는 학생 많은 순
            });

            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    if (map[x][y] != 0) continue; 

                    int fcount = 0;
                    int ncount = 0;
                    for (int[] move : moves) {
                        int dx = x + move[0];
                        int dy = y + move[1];
                        if (dx >= 0 && dx < n && dy >= 0 && dy < n) {
                            if (graph.get(cnt).containsKey(map[dx][dy])) fcount++;
                            if (map[dx][dy] == 0) ncount++;
                        }
                    }
                    pq.add(new int[]{fcount, ncount, x, y});
                }
            }

            int[] best = pq.poll();
            if (best != null) {
                map[best[2]][best[3]] = cnt;
            }
        }
        int result = 0;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                Map<Integer, Integer> cnt = graph.get(map[x][y]);
                int count = 0;
                for (int[] move : moves) {
                    int dx = x + move[0];
                    int dy = y + move[1];
                    if (dx >= 0 && dx < n && dy >= 0 && dy < n) {
                        if (cnt.containsKey(map[dx][dy])) count++;
                    }
                }     
                switch (count) {
                    case 0:
                        break;
                    case 1:
                        result += 1;
                        break;
                    case 2:
                        result += 10;
                        break;
                    case 3:
                        result += 100;
                        break;
                    case 4:
                        result += 1000;
                        break;
                
                }
            }
        }

        System.out.println(result);
    }
}

//비어있는 칸 중에서 종아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정함
// 위를 만족하게 여러개면 비어있는 칸이 가장 많은 칸을 정함
// 2를 만족하는 칸도 여러 개인 경우 행 번호가 작은 칸을 정함
// 1. 좋아하는 사람이 많은 칸을 검사
// 2. 여러개면 주변 비어잇는 칸이 가장 많아야함
// 3. 어러개면 행 번호가 작은 순 