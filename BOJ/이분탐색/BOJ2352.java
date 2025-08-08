import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		List<Integer> li = new ArrayList<>();

		for(int i = 0; i < n; i++){
			int cnt = Integer.parseInt(st.nextToken());
			int pos = Collections.binarySearch(li, cnt);

			if(pos < 0) {
				pos = -(pos + 1);
			}

			if(pos == li.size()) {
				li.add(cnt);
			} else {
				li.set(pos, cnt);
			}
		}

		System.out.println(li.size());
	}

}
