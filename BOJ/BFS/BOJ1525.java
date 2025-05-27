import java.io.*;
import java.util.*;

public class Main {

    static class Node{
        int map[][];
        int count;
        int x, y;

        Node(int map[][], int count, int x, int y){
            this.map = map;
            this.count = count;
            this.x = x;
            this.y = y;
        }   
    }
    static int moves[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int map[][] = new int[4][4];
        for(int i = 1; i <= 3; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= 3; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int target_x = 0;
        int target_y = 0;

        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if(map[i][j] == 0){
                    target_x = i;
                    target_y = j;
                }
            }
        }

        HashSet<String> hs = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(copyMap(map), 0, target_x, target_y));
        hs.add(getString(map));

        while(!q.isEmpty()){
            Node node = q.poll();

            if(getString(node.map).equals("123456780")){
                System.out.println(node.count);
                return;
            }

            for(int[] move : moves){
                int dx = node.x + move[0];
                int dy = node.y + move[1];

                if(dx >= 1 && dx < 4 && dy >= 1 && dy < 4){
                    int copy[][] = copyMap(node.map);
                    
                    int temp = copy[node.x][node.y];
                    copy[node.x][node.y] = copy[dx][dy];
                    copy[dx][dy] = temp;

                    String target = getString(copy);
                    if(!hs.contains(target)){
                        q.add(new Node(copy, node.count + 1, dx, dy));
                        hs.add(target);
                    }
                }
            }
        }

        System.out.println(-1);
        return;
    }


    public static String getString(int[][] map) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                sb.append(map[i][j]);
            }
        }
        return sb.toString();
    }


    public static int[][] copyMap(int map[][]){
        int[][] copy = new int[4][4];
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                copy[i][j] = map[i][j];
            }
        }
        return copy;
    }

}
