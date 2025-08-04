import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int map[][];
    static int result = 0;
    static int d[] = {0,1,2,3};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(0, map);
        System.out.println(result);
    }

    public static void dfs(int depth, int m[][]){
        if(depth == 5){
            getResult(m);
            return;
        }

        for(int dir : d){
            int temp[][] = cloneMap(m);
            temp = setMap(dir, temp); 
            dfs(depth+1, temp);
        }

    }

    public static int[][] setMap(int flag, int[][] m) {
        int[][] temp = cloneMap(m);

        switch (flag) {
            case 0: // ← 왼쪽
                for (int i = 0; i < n; i++) {
                    List<Integer> li = new ArrayList<>();
                    for (int j = 0; j < n; j++) {
                        if (temp[i][j] != 0)
                            li.add(temp[i][j]);
                    }

                    for (int j = 0; j < li.size() - 1; j++) {
                        if (li.get(j).equals(li.get(j + 1))) {
                            li.set(j, li.get(j) * 2);
                            li.remove(j + 1);
                        }
                    }

                    while (li.size() < n) li.add(0);

                    for (int j = 0; j < n; j++)
                        temp[i][j] = li.get(j);
                }
                break;

            case 1: // → 오른쪽
                for (int i = 0; i < n; i++) {
                    List<Integer> li = new ArrayList<>();
                    for (int j = n - 1; j >= 0; j--) {
                        if (temp[i][j] != 0)
                            li.add(temp[i][j]);
                    }

                    for (int j = 0; j < li.size() - 1; j++) {
                        if (li.get(j).equals(li.get(j + 1))) {
                            li.set(j, li.get(j) * 2);
                            li.remove(j + 1);
                        }
                    }

                    while (li.size() < n) li.add(0);

                    for (int j = 0; j < n; j++)
                        temp[i][n - 1 - j] = li.get(j); 
                }
                break;

            case 2: // ↑ 위쪽
                for (int j = 0; j < n; j++) {
                    List<Integer> li = new ArrayList<>();
                    for (int i = 0; i < n; i++) {
                        if (temp[i][j] != 0)
                            li.add(temp[i][j]);
                    }

                    for (int i = 0; i < li.size() - 1; i++) {
                        if (li.get(i).equals(li.get(i + 1))) {
                            li.set(i, li.get(i) * 2);
                            li.remove(i + 1);
                        }
                    }

                    while (li.size() < n) li.add(0);

                    for (int i = 0; i < n; i++)
                        temp[i][j] = li.get(i);
                }
                break;

            case 3: // ↓ 아래쪽
                for (int j = 0; j < n; j++) {
                    List<Integer> li = new ArrayList<>();
                    for (int i = n - 1; i >= 0; i--) {
                        if (temp[i][j] != 0)
                            li.add(temp[i][j]);
                    }

                    for (int i = 0; i < li.size() - 1; i++) {
                        if (li.get(i).equals(li.get(i + 1))) {
                            li.set(i, li.get(i) * 2);
                            li.remove(i + 1);
                        }
                    }

                    while (li.size() < n) li.add(0);

                    for (int i = 0; i < n; i++)
                        temp[n - 1 - i][j] = li.get(i); 
                }
                break;
        }

        return temp;
    }

    public static int[][] cloneMap(int m[][]){
        int temp[][] = new int[n][n];

        for(int i = 0; i < n; i++){
            temp[i] = m[i].clone();
        }
        return temp;
    }
    public static void getResult(int m[][]){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                result = Math.max(m[i][j], result);
            }
        }
    }
}
