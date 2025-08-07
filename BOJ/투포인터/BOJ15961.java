import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] belt = new int[n];
		for (int i = 0; i < n; i++) {
			belt[i] = Integer.parseInt(br.readLine());
		}

		int[] count = new int[d + 1];
		int unique = 0;
		int max = 0;

		for (int i = 0; i < k; i++) {
			if (count[belt[i]] == 0) unique++;
			count[belt[i]]++;
		}
		max = (count[c] == 0) ? unique + 1 : unique;

		for (int i = 1; i < n; i++) {
			int remove = belt[i - 1];           
			int add = belt[(i + k - 1) % n];   

			count[remove]--;
			if (count[remove] == 0) unique--;

			if (count[add] == 0) unique++;
			count[add]++;

			int temp = (count[c] == 0) ? unique + 1 : unique;
			max = Math.max(max, temp);
		}

		System.out.println(max);
	}
}
