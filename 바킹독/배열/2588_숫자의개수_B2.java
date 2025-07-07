import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long result = 1;

        result *= Integer.parseInt(br.readLine());
        result *= Integer.parseInt(br.readLine());
        result *= Integer.parseInt(br.readLine());

        int arr[] = new int[11];
        while(result != 0){
            arr[(int) result % 10]++;
            result = result / 10;
        }

        for(int i = 0; i <= 9; i++){
            System.out.println(arr[i]);
        }
    }
}