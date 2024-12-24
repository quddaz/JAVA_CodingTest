import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max[] = new int[n];
        int min[] = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            max[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            min[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(max);
        Arrays.sort(min);

        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += max[i] * min[n-i-1];
        }
        System.out.println(sum);
    }
}
