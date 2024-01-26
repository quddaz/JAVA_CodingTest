import java.util.*;

public class Main {
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static boolean visited[];

    public static void init(int N){
        visited= new boolean[N];
        for(int i= 0;i < N; i++){
            graph.add(new ArrayList<Integer>());
        }
    }
    public static void addGraph(int a, int b){
        graph.get(a).add(b);
        graph.get(b).add(a);
    }
    public static int dfs(int N){
        visited[N] = true;
        int count = 1;
        for(int i = graph.get(N).size()-1; i>=0; i--){
            int temp = graph.get(N).get(i);
            if(!visited[temp])
                count += dfs(temp);
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        init(N);
        int M = sc.nextInt();
        for(int i = 0; i<M;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            addGraph(a-1, b-1);
        }

        System.out.println(dfs(0)-1);
    }
}