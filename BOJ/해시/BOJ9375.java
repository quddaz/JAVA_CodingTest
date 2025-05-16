import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            Map<String, HashSet<String>> m = new HashMap<>();
            int n = Integer.parseInt(br.readLine());

            for(int i = 0; i < n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                m.computeIfAbsent(b, k -> new HashSet<>()).add(a);
            }
            int result = 1;
            for(HashSet<String> h : m.values()){
                result *= (h.size() + 1);
            }
            result -= 1;
            System.out.println(result);
        }

    }
}
