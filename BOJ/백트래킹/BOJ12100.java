import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    static int n;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int map[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, map);
        System.out.println(result);
    }

    public static void solve(int depth, int map[][]) {
        if (depth == 5) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    count = Math.max(count, map[i][j]);
                }
            }
            result = Math.max(result, count);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int[][] temp = setMap(i, map);
            solve(depth + 1, temp);
        }
    }

    public static int[][] setMap(int direction, int[][] map) {
        int[][] newMap = new int[n][n];

        switch (direction) {
            case 0:
                for (int j = 0; j < n; j++) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    for (int i = 0; i < n; i++) {
                        if (map[i][j] != 0) {
                            temp.add(map[i][j]);
                        }
                    }

                    for (int i = 0; i < temp.size() - 1; i++) {
                        if (temp.get(i).equals(temp.get(i + 1))) {
                            temp.set(i, temp.get(i) * 2);
                            temp.remove(i + 1);
                        }
                    }

                    while (temp.size() < n) {
                        temp.add(0);
                    }

                    for (int i = 0; i < n; i++) {
                        newMap[i][j] = temp.get(i);
                    }
                }
                break;
            case 1:
                for (int j = 0; j < n; j++) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    for (int i = n - 1; i >= 0; i--) {
                        if (map[i][j] != 0) {
                            temp.add(map[i][j]);
                        }
                    }

                    for (int i = 0; i < temp.size() - 1; i++) {
                        if (temp.get(i).equals(temp.get(i + 1))) {
                            temp.set(i, temp.get(i) * 2);
                            temp.remove(i + 1);
                        }
                    }

                    while (temp.size() < n) {
                        temp.add(0);
                    }

                    for (int i = 0; i < n; i++) {
                        newMap[i][j] = temp.get(i);
                    }
                }
                break;
            case 2:
                for (int i = 0; i < n; i++) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    for (int j = 0; j < n; j++) {
                        if (map[i][j] != 0) {
                            temp.add(map[i][j]);
                        }
                    }

                    for (int j = 0; j < temp.size() - 1; j++) {
                        if (temp.get(j).equals(temp.get(j + 1))) {
                            temp.set(j, temp.get(j) * 2);
                            temp.remove(j + 1);
                        }
                    }

                    while (temp.size() < n) {
                        temp.add(0);
                    }

                    for (int j = 0; j < n; j++) {
                        newMap[i][j] = temp.get(j);
                    }
                }
                break;
            case 3:
                for (int i = 0; i < n; i++) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    for (int j = n - 1; j >= 0; j--) {
                        if (map[i][j] != 0) {
                            temp.add(map[i][j]);
                        }
                    }

                    for (int j = 0; j < temp.size() - 1; j++) {
                        if (temp.get(j).equals(temp.get(j + 1))) {
                            temp.set(j, temp.get(j) * 2);
                            temp.remove(j + 1);
                        }
                    }

                    while (temp.size() < n) {
                        temp.add(0);
                    }

                    for (int j = 0; j < n; j++) {
                        newMap[i][j] = temp.get(j);
                    }
                }
                break;
        }

        return newMap;
    }
}
