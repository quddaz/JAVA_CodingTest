import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Position {
    int x, y;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class KnightMoves {
    // 나이트가 이동할 수 있는 8가지 방향
    static int[] dx = {2, 2, 1, 1, -1, -1, -2, -2};
    static int[] dy = {1, -1, 2, -2, 2, -2, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 

        for (int i = 0; i < t; i++) {
            int l = sc.nextInt(); 
            int[][] board = new int[l][l];

            Position start = new Position(sc.nextInt(), sc.nextInt());
            Position end = new Position(sc.nextInt(), sc.nextInt());

            int result = bfs(l, start, end, board);
            System.out.println(result);
        }

        sc.close();
    }

    public static int bfs(int l, Position start, Position end, int[][] board) {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(start);
        board[start.x][start.y] = 1; 

        while (!queue.isEmpty()) {
            Position pos = queue.poll();

            if (pos.x == end.x && pos.y == end.y) {
                return board[pos.x][pos.y] - 1;
            }

            for (int i = 0; i < 8; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];


                if (nx >= 0 && ny >= 0 && nx < l && ny < l && board[nx][ny] == 0) {
                    queue.offer(new Position(nx, ny));
                    board[nx][ny] = board[pos.x][pos.y] + 1;
                }
            }
        }
        return -1; 
    }
}
