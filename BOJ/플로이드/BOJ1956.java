import java.io.*;
import java.util.*;

public class Main {
	static final int INF = 1_000_000_000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int map[][] = new int[n + 1][n + 1];

		for(int i = 1; i <= n; i++) Arrays.fill(map[i], INF);
		for(int i = 1; i <= n; i++) map[i][i] = 0;
		for(int i = 0; i < m; i++){
			st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			map[to][from] = dist;
		}


		for(int k = 1; k <= n; k++){
			for(int i = 1; i <= n; i++){
				for(int j = 1; j <= n; j++){
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}

		int result = INF;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i != j && map[i][j] != INF && map[j][i] != INF) {
					result = Math.min(result, map[i][j] + map[j][i]);
				}
			}
		}
		System.out.println(result == INF ? -1 : result);
	}

}
