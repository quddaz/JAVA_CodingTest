import java.util.*;
import java.io.*;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        for(int i = 1; i <= 10; i++){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int result = 0;
            int[] num = new int[N];
            for(int j = 0; j < N; j++){
                num[j] = Integer.parseInt(st.nextToken());
            }
            for(int j = 2; j < N-2; j++){
                result += Math.max(0,num[j] - Math.max(Math.max(num[j+1], num[j+2]),Math.max(num[j-1], num[j-2])));
            }
            System.out.println("#" + i +" "+result);
        }
    }
}