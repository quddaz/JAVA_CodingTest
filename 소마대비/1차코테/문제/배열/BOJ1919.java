import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        int arr[] = new int[26];

        for(char c : a.toCharArray()){
            arr[c - 'a']++;
        }

        for(char c : b.toCharArray()){
            arr[c - 'a']--;
        }

        int result = 0;
        for(int num : arr){
            result += Math.abs(num);
        }
        System.out.println(result);

    }
}
