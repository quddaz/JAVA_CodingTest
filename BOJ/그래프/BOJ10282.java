import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static class Node{
		int to;
		int distance;

		Node(int to, int distance){
			this.to = to;
			this.distance = distance;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		

		while(t-- > 0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			List<List<Node>> li = new ArrayList<>();
			for(int i = 0; i <= n; i++){
				li.add(new ArrayList<>());
			}
			
			for(int i = 0; i < d; i++){
				st = new StringTokenizer(br.readLine());
				int to = Integer.parseInt(st.nextToken());
				int from = Integer.parseInt(st.nextToken());
				int distance = Integer.parseInt(st.nextToken());

				li.get(from).add(new Node(to, distance));
			}

			PriorityQueue<Node> q = new PriorityQueue<>((a,b) -> a.distance - b.distance);
			int[] dist = new int[n + 1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[c] = 0;

			q.add(new Node(c, 0));

			while(!q.isEmpty()){
				Node cur = q.poll();
				int now = cur.to;
				int time = cur.distance;

				if(dist[now] < time) continue;

				for(Node next : li.get(now)){
					if(dist[next.to] > dist[now] + next.distance){
						dist[next.to] = dist[now] + next.distance;
						q.add(new Node(next.to, dist[next.to]));
					}
				}
			}

			int count = 0;
			int result = 0;
			for(int i = 1; i <= n; i++){
				if(dist[i] != Integer.MAX_VALUE){
					count++;
					result = Math.max(result, dist[i]);
				}
			}
			System.out.println(count + " " + result);

		}
	}
	
}
