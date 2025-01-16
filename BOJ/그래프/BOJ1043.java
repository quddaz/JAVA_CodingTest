import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> partys = new ArrayList<>();
    static int n, m;
    static boolean truthPeople[];
    static int parent[];
    static int rank[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        truthPeople = new boolean[n + 1];
        parent = new int[n + 1];
        rank = new int[n + 1];
        // 일단 자신으로 초기화
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int truthCount = Integer.parseInt(st.nextToken());
        for (int i = 0; i < truthCount; i++) {
            truthPeople[Integer.parseInt(st.nextToken())] = true;
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int partySize = Integer.parseInt(st.nextToken());
            List<Integer> party = new ArrayList<>();
            for (int j = 0; j < partySize; j++) {
                party.add(Integer.parseInt(st.nextToken()));
            }
            partys.add(party);
            for (int j = 1; j < party.size(); j++) {
                union(party.get(0), party.get(j));
            }
        }

        // 진실을 아는 사람들의 루트를 기준으로 연결된 사람들을 진실을 아는 사람으로 설정
        for (int i = 1; i <= n; i++) {
            if (truthPeople[i]) {
                int root = find(i);
                for (int j = 1; j <= n; j++) {
                    if (find(j) == root) {
                        truthPeople[j] = true;
                    }
                }
            }
        }

        int count = 0;
        // 각 파티에 대해 진실을 아는 사람이 있는지 체크
        for (List<Integer> party : partys) {
            boolean isSafe = true;
            for (int person : party) {
                if (truthPeople[person]) {
                    isSafe = false;
                    break;
                }
            }
            if (isSafe) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}
import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static int n, m;
    static boolean truthPeople[];
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        truthPeople = new boolean[n + 1];
        visited = new boolean[n + 1];

        st = new StringTokenizer(br.readLine());
        int truthCount = Integer.parseInt(st.nextToken());
        for (int i = 0; i < truthCount; i++) {
            truthPeople[Integer.parseInt(st.nextToken())] = true;
        }

        for (int i = 0; i <= m; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int partySize = Integer.parseInt(st.nextToken());
            for (int j = 0; j < partySize; j++) {
                graph.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i] && truthPeople[i]) {
                dfs(i);
            }
        }

        int count = 0;
        for (int i = 1; i <= m; i++) {
            boolean temp = false;
            for (int next : graph.get(i)) {
                if (truthPeople[next]) {
                    temp = true;
                    break;
                }
            }

            if (!temp) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static void dfs(int num) {
        visited[num] = true;

        for (int i = 1; i <= m; i++) {
            if (graph.get(i).contains(num)) {
                for (int next : graph.get(i)) {
                    if (!visited[next] && !truthPeople[next]) {
                        truthPeople[next] = true;
                        dfs(next);
                    }
                }
            }
        }
    }
}
