import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int a[] = new int[n];
        int b[] = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) b[i] = Integer.parseInt(st.nextToken());

        int aidx = 0;
        int bidx = 0;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n+m; i++){
            if(aidx >= n) sb.append(b[bidx++]).append(" ");
            else if(bidx >= m) sb.append(a[aidx++]).append(" ");
            else if(a[aidx] > b[bidx]) sb.append(b[bidx++]).append(" ");
            else sb.append(a[aidx++]).append(" ");
        }

        System.out.println(sb);

    }
}
