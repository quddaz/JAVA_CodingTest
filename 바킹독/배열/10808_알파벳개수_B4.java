import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int arr[] = new int[26];

        for(int i = 0; i < str.length(); i++){
            char cnt = str.charAt(i);
            arr[cnt - 'a']++;
        }


        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}