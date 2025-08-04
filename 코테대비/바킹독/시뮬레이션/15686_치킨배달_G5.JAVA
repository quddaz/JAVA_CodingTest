import java.io.*;
import java.util.*;

public class Main {
    public static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int n, m;
    static int map[][];
    static List<Node> chi = new ArrayList<>();
    static List<Node> home = new ArrayList<>();
    static Set<List<Node>> s = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                int cnt = Integer.parseInt(st.nextToken());
                if(cnt == 1){
                    home.add(new Node(i,j));
                }else if(cnt == 2){
                    chi.add(new Node(i, j));
                }
                map[i][j] = cnt;
            }
        }

        dfs(new ArrayList<>(), 0);


        int result = Integer.MAX_VALUE;

        for(List<Node> li : s){
            int sum = 0;
            for(Node node : home){
                int minRange = Integer.MAX_VALUE;
                for(Node node2 : li){
                    minRange = Math.min(minRange, Math.abs(node.x - node2.x) + Math.abs(node.y - node2.y));
                }
                sum += minRange;
            }
            result  = Math.min(result, sum);
        }
        System.out.println(result);
    }

    public static void dfs(List<Node> cnt, int start){
        if(cnt.size() == m){
            s.add(new ArrayList<>(cnt));
            return;
        }


        for(int i = start; i < chi.size(); i++){
            cnt.add(chi.get(i));
            dfs(cnt, i + 1);
            cnt.remove(cnt.size() - 1);
        }
    }
}
