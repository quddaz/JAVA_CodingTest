import java.util.*;
import java.io.*;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int count = 0;
            while(a + b <= c){
                if(a > b){
                    b += a;
                }
                else{
                    a += b;
                }
                count++;
            }
            System.out.println(count+1);
        }
          
    }
}