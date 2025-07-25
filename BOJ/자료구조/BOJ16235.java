import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[][] A; // 겨울에 추가할 양분
    static int[][] nutrients; // 현재 양분 상태
    static LinkedList<Integer>[][] trees; // 각 칸의 나무들 (LinkedList로 정렬 유지)
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N][N];
        nutrients = new int[N][N];
        trees = new LinkedList[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                nutrients[i][j] = 5; // 초기 양분
                trees[i][j] = new LinkedList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1; // 0-based
            int y = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());
            trees[x][y].add(age);
        }

        for (int year = 0; year < K; year++) {
            springAndSummer();
            fall();
            winter();
        }

        System.out.println(countTrees());
    }

    static void springAndSummer() {
        int[][] deadNutrients = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                LinkedList<Integer> live = new LinkedList<>();
                Collections.sort(trees[i][j]); // 나이 어린 순서대로

                for (int age : trees[i][j]) {
                    if (nutrients[i][j] >= age) {
                        nutrients[i][j] -= age;
                        live.add(age + 1);
                    } else {
                        deadNutrients[i][j] += age / 2;
                    }
                }

                trees[i][j] = live;
                nutrients[i][j] += deadNutrients[i][j];
            }
        }
    }

    static void fall() {
        List<int[]> toAdd = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int age : trees[i][j]) {
                    if (age % 5 == 0) {
                        for (int d = 0; d < 8; d++) {
                            int nx = i + dx[d];
                            int ny = j + dy[d];
                            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                                trees[nx][ny].addFirst(1); // 나이 1짜리 나무는 앞에 넣기
                            }
                        }
                    }
                }
            }
        }
    }

    static void winter() {
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                nutrients[i][j] += A[i][j];
    }

    static int countTrees() {
        int count = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                count += trees[i][j].size();
        return count;
    }
}