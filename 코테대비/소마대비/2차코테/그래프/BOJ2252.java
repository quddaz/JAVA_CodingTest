import java.util.;
import java.io.;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());  
        int m = Integer.parseInt(st.nextToken()); 

        ListInteger[] graph = new ArrayList[n + 1];  
        int[] inDegree = new int[n + 1]; 

        for (int i = 1; i = n; i++) {
            graph[i] = new ArrayList();
        }

        for (int i = 0; i  m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b); 
            inDegree[b]++; 
        }

        QueueInteger queue = new LinkedList();
        for (int i = 1; i = n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        ListInteger result = new ArrayList();

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            result.add(curr);

            for (int next  graph[curr]) {
                inDegree[next]--; 
                if (inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        for (int num  result) {
            System.out.print(num +  );
        }
    }
}
