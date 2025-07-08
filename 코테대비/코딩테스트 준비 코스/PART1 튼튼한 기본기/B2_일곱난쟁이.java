import java.io.*;
import java.util.*;

public class B2_2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arr[] = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        boolean found = false;

        for (int i = 0; i < arr.length && !found; i++) {
            for (int j = i + 1; j < arr.length && !found; j++) {
                if (sum - arr[i] - arr[j] == 100) {
                    arr[i] = -1;
                    arr[j] = -1;
                    found = true; 
                }
            }
        }

        Arrays.sort(arr);
        for (int i = 2; i < 9; i++) {  
            System.out.println(arr[i]);
        }
    }
}