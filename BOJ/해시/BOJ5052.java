import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Boolean> map = new HashMap<>();
            String[] arr = new String[n];

            for (int i = 0; i < n; i++) {
                arr[i] = br.readLine();
            }

            for (String phone : arr) {
                map.put(phone, false);
            }

            boolean flag = false;

            for (String phone : arr) {
                for (int len = 1; len < phone.length(); len++) {
                    String prefix = phone.substring(0, len);
                    if (map.containsKey(prefix) && map.get(prefix) == false) {
                        flag = true;
                        break;
                    }
                }
                if (flag) break;
            }

            System.out.println(flag ? "NO" : "YES");
        }
    }
}
