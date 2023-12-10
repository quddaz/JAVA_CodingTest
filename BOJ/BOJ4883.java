import java.util.Scanner;

public class Main {
    	// 백준 4883번 삼각 그래프
    public static void main(String[] args) {
        Scanner std = new Scanner(System.in);
        int N;
        int data[][];
        int graph[][];
        int count = 1;
        while (true) { 
            N = std.nextInt();
            if (N == 0) break;
            data = new int[N][3];
            graph = new int[N][3];
            for (int i = 0; i < N; i++)
                for (int j = 0; j < 3; j++)
                    graph[i][j] = std.nextInt();

            data[1][0] = graph[1][0] + graph[0][1];
            data[1][1] = graph[1][1] + Math.min(data[1][0],Math.min(graph[0][1],graph[0][2]+graph[0][1]));
            data[1][2] = graph[1][2] + Math.min(data[1][1],Math.min(graph[0][1],graph[0][2]+graph[0][1]));
            for (int i = 2; i < N; i++){
                    data[i][0] = Math.min(data[i - 1][0], data[i - 1][1]) + graph[i][0];
                    data[i][1] = Math.min(data[i - 1][0], Math.min(Math.min(data[i - 1][1], data[i - 1][2]), data[i][0])) + graph[i][1];
                    data[i][2] = Math.min(data[i - 1][1], Math.min(data[i - 1][2], data[i][1])) + graph[i][2];
        }
            System.out.println(count++ + ". " + data[N - 1][1]); 
        }
    }
}
