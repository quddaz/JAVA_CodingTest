import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int M = Integer.parseInt(br.readLine());
        int S = 0; // 비트 마스크로 집합을 표현

        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String operation = st.nextToken();
            
            switch (operation) {
                case "add":
                    int addValue = Integer.parseInt(st.nextToken());
                    S |= (1 << (addValue - 1));
                    break;
                
                case "remove":
                    int removeValue = Integer.parseInt(st.nextToken());
                    S &= ~(1 << (removeValue - 1));
                    break;
                
                case "check":
                    int checkValue = Integer.parseInt(st.nextToken());
                    if ((S & (1 << (checkValue - 1))) != 0) {
                        sb.append("1\n");
                    } else {
                        sb.append("0\n");
                    }
                    break;
                
                case "toggle":
                    int toggleValue = Integer.parseInt(st.nextToken());
                    S ^= (1 << (toggleValue - 1));
                    break;
                
                case "all":
                    S = (1 << 20) - 1;
                    break;
                
                case "empty":
                    S = 0;
                    break;
            }
        }
        
        System.out.print(sb);
    }
}
