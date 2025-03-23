import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        while (T-- > 0) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            
            sb.append(minWarpCount(x, y)).append("\n");
        }
        System.out.print(sb);
    }
    
    public static int minWarpCount(int x, int y) {
        int distance = y - x;
        int maxMove = (int) Math.sqrt(distance);
        
        if (maxMove * maxMove == distance) {
            return 2 * maxMove - 1;
        } else if (distance <= maxMove * maxMove + maxMove) {
            return 2 * maxMove;
        } else {
            return 2 * maxMove + 1;
        }
    }
}
