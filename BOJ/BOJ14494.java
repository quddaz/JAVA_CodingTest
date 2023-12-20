import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long dp[][] = new long[1020][1020];
		int num = 1000000007;
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		dp[0][0] = 1;
		dp[1][1] = 1;
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				dp[i][j] = (dp[i-1][j]%num + dp[i][j-1]%num + dp[i-1][j-1]%num)%num;
			}
		}
		System.out.println(dp[n][m]%num);
	}
}