import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int a[] = new int[t];
		int b[] = new int[t];
		int c[] = new int[t];
		int d[] = new int[t];

		for(int i = 0; i < t; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			a[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
			c[i] = Integer.parseInt(st.nextToken());
			d[i] = Integer.parseInt(st.nextToken());
		}

		int ab[] = new int[t * t];
		int cd[] = new int[t * t];
		int idx = 0;
		for(int i = 0; i < t; i++){
			for(int j = 0; j < t; j++){
				ab[idx] = a[i] + b[j];
				cd[idx++] = c[i] + d[j];
			}
		}
		Arrays.sort(ab);
		Arrays.sort(cd);

		int left = 0;
		int right = cd.length - 1;
		long count = 0;

		while(left < ab.length && right >= 0){
		int sum = ab[left] + cd[right];

			if(sum == 0){
				int abVal = ab[left];
				int cdVal = cd[right];
				long abCount = 0;
				long cdCount = 0;

				while(left < ab.length && ab[left] == abVal){
					abCount++;
					left++;
				}

				while(right >= 0 && cd[right] == cdVal){
					cdCount++;
					right--;
				}

				count += abCount * cdCount;
			}
			else if(sum < 0){
				left++;
			} else {
				right--;
			}
		}

		System.out.println(count);
	}
}
