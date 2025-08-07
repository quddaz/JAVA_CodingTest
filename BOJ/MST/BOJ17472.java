import java.io.*;
import java.util.*;

public class Main {
	static class Edge{
		int from;
		int to;
		int dist;

		Edge(int from, int to, int dist){
			this.from = from;
			this.to = to;
			this.dist = dist;
		}
	}
	static int n,m;
	static int map[][];
	static int island[][];
	static List<List<Edge>> li = new ArrayList<>();
	static PriorityQueue<Edge> q = new PriorityQueue<>((a,b) -> a.dist - b.dist);
	static int[][] moves = {{1,0},{-1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		island = new int[n][m];

		for(int i = 0; i < n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j< m; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int count = 1;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				if(island[i][j] == 0 && map[i][j] == 1){
					dfs(i,j, count);
					count++;
				}
			}
		}

		for(int i = 0; i <= count; i++){
			li.add(new ArrayList<>());
		}

		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				if(island[i][j] != 0){
					make(i,j);
				}
			}
		}

		int result = 0;
		boolean visited[] = new boolean[count];
		visited[1] = true;
		int visitCount = 1;

		for(Edge e : li.get(1)){
			q.add(e);
		}
		while(!q.isEmpty()){
			Edge cnt = q.poll();

			if(visited[cnt.to]) continue;
			visited[cnt.to] = true;
			result += cnt.dist;
			visitCount++;
			for(Edge e : li.get(cnt.to)){
				q.add(e);
			}
		}

		if(visitCount == count - 1) System.out.println(result);
		else System.out.println(-1);
	}
	public static void make(int x, int y){
		int from = island[x][y];

		for(int[] move : moves) {
			int dist = 0;
			int dx = x + move[0];
			int dy = y + move[1];

			while(true) {
				if(dx < 0 || dx >= n || dy < 0 || dy >= m) break;

				if(island[dx][dy] == from) break; 

				if(island[dx][dy] == 0) {
					dist++;
					dx += move[0];
					dy += move[1];
				} else { 
					if(dist >= 2) {
						int to = island[dx][dy];
						li.get(from).add(new Edge(from, to, dist));
						li.get(to).add(new Edge(to, from, dist));
					}
					break;
				}
			}
		}
	}
	public static void dfs(int x, int y, int count){
		if(island[x][y] == 0){
			island[x][y] = count;
		}

		for(int[] move : moves){
			int dx = x + move[0];
			int dy = y + move[1];

			if(dx < 0 || dx >= n || dy < 0 || dy >= m) continue;
			if(island[dx][dy] != 0) continue;
			if(map[dx][dy] == 0) continue;

			dfs(dx,dy,count);
		}
	}
}
