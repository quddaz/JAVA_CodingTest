import java.io.*;
import java.util.*;

public class B3_3460 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
           int n = Integer.parseInt(br.readLine());
           String binary = Integer.toBinaryString(n);
           for(int j = 0; j < binary.length(); j++){
                if(binary.charAt(binary.length() - 1 - j) == '1'){
                    System.out.print(j + " ");
                }
           }
           System.out.println();
        }
    }
}