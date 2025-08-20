import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int s[] = new int[n];
		int b[] = new int[n];

		int answer = Integer.MAX_VALUE;

		for(int i = 0; i < n; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			s[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
		}

		for(int mask = 1; mask < (1 << n); mask++){
			int sour = 1;
			int bitter = 0;

			for(int i = 0; i < n; i++){
				if((mask & (1 << i)) != 0){
					sour *= s[i];
					bitter += b[i];
				}
			}

			answer = Math.min(answer, Math.abs(sour - bitter));
		}

		System.out.println(answer);
	}

}
