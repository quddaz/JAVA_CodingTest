import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String [] args){
        int N;
        int arr[], dp[];

        Scanner scan= new Scanner(System.in);

        N= scan.nextInt();
        arr= new int[N];
        dp= new int[N+1];

        for(int i=0; i<N; i++) {
            arr[i]=scan.nextInt();
        }//end for
    
        dp[0]=0;
        dp[1]=arr[0];
        if(N>=2) dp[2]=arr[0]+arr[1];
        
        for(int i=3; i<=N; i++) {
            dp[i]=Math.max(dp[i-3]+arr[i-2]+arr[i-1], dp[i-2]+arr[i-1]);
            dp[i]=Math.max(dp[i-1], dp[i]);
        }

        System.out.println(dp[N]);
    }
}