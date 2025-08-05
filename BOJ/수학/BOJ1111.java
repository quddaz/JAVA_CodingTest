import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(solution(arr, n));
	}
	
	public static String solution(int[] arr, int n) {
		if(n == 1) return "A";
		
		if(n == 2) {
			if(arr[0] == arr[1]) return String.valueOf(arr[0]);
			else return "A";
		}
		
		int x1 = arr[0], x2 = arr[1], x3 = arr[2];
		
		int denominator = x2 - x1;
		int numerator = x3 - x2;
		
		Integer a = null;
		
		if (denominator == 0) {
			if (numerator != 0) return "B"; 
			a = 0;
		} else {
			if (numerator % denominator != 0) return "B";
			a = numerator / denominator;
		}
		
		int b = x2 - x1 * a;
		
		for (int i = 1; i < n; i++) {
			if (arr[i] != arr[i - 1] * a + b) return "B";
		}
		
		return String.valueOf(arr[n - 1] * a + b);
	}
}
