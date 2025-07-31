import java.io.*;
import java.util.*;

public class Main {
    static int[] start, end;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        start = new int[n];
        end = new int[n];
        String str1 = br.readLine();
        String str2 = br.readLine();

        for(int i = 0; i < n; i++){
            start[i] = str1.charAt(i) - '0';
            end[i] = str2.charAt(i) - '0'; 
        }

        int result1 = solve(start.clone(), false);
        int result2 = solve(start.clone(), true);

        if(result1 == -1 && result2 == -1) System.out.println(-1);
        else if(result1 == -1) System.out.println(result2);
        else if(result2 == -1) System.out.println(result1);
        else System.out.println(Math.min(result1,result2));
        return;
    }

    public static int solve(int arr[], boolean flag){
        int count = 0;

        if(flag){
            arr = press(arr, 0);
            count++;
        }

        for(int i = 1; i < n; i++){
            if(arr[i - 1] != end[i - 1]){
                arr = press(arr, i);
                count++;
            }
        }

        for(int i = 0; i < n; i++){
            if(arr[i] != end[i])
                return -1;
        }

        return count;
    }

    public static int[] press(int arr[], int idx){

        for(int i = idx - 1; i <= idx + 1; i++){
            if(i >= 0 && i < n)
                arr[i] = arr[i] == 0 ? 1 : 0;
        }

        return arr;
    }

    
}
