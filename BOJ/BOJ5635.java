import java.io.*;
import java.util.*; 
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		String [] name = new String[n];
		int [][] date = new int[n][4];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			name[i]=st.nextToken();
			date[i][0]=i;
			for(int j=1;j<=3;j++)
				date[i][j]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(date, (o1, o2) -> o1[1]-o2[1]);
		Arrays.sort(date, (o1, o2) -> o1[2]-o2[2]);
		Arrays.sort(date, (o1, o2) -> o1[3]-o2[3]);
		System.out.println(name[date[n-1][0]]+"\n"+name[date[0][0]]);
	}
}
