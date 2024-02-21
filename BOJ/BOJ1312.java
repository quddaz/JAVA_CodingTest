import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main { 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());
		int n=Integer.parseInt(st.nextToken());
		
		while (true) {
			if (a<b) break;
			a=a%b;
		}
		//System.out.println(a);
		
		int ans = 0;
		
		for (int i=0; i<n;i++) {
			a=a*10;
			ans=a/b; 
			a=a%b;
		}
		System.out.println(ans);
	}
}