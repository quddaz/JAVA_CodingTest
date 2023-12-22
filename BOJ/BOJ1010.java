import java.io.*;
import java.util.*;
public class Main{
    public static void main(String arg[]) throws IOException{
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    	int T=Integer.parseInt(br.readLine());
    	int Count[][] = new int[30][30];
        for(int i =0; i <T;i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	int a = effect(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Count);
        	bw.write(a+"\n");
        }
        br.close();
        bw.close();
    }
    public static int effect(int n, int m, int[][] Count) {
    	if(Count[n][m] != 0)
    		return Count[n][m];
    	if(n == 1)
    		return m;
    	else if( n == m || m == 1 )
    	   	return 1;

    	Count[n][m] = effect(n,m-1,Count) + effect(n-1,m-1,Count);
    	return Count[n][m];
    }
}