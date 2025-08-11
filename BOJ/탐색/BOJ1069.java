import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double X = Double.parseDouble(st.nextToken());
        double Y = Double.parseDouble(st.nextToken());
        double D = Double.parseDouble(st.nextToken());
        double T = Double.parseDouble(st.nextToken());

        double dist = Math.sqrt(X * X + Y * Y);

        double ans = dist; 
        if (dist >= D) {
            ans = Math.min(ans, T + (dist - D)); 
            ans = Math.min(ans, (Math.floor(dist / D) * T) + (dist % D));
            ans = Math.min(ans, (Math.ceil(dist / D)) * T); 
        } else {
            ans = Math.min(ans, T + (D - dist)); 
            ans = Math.min(ans, 2 * T);          
        }

        System.out.println(ans);
    }
}