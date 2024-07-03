
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine()); // 초기 문자열을 StringBuilder로 처리
        int n = Integer.parseInt(br.readLine());
        
        int cursor = sb.length(); // 초기 커서 위치는 문자열의 끝
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char command = st.nextToken().charAt(0);
            
            switch (command) {
                case 'L':
                    if (cursor > 0) {
                        cursor--;
                    }
                    break;
                case 'D':
                    if (cursor < sb.length()) {
                        cursor++;
                    }
                    break;
                case 'B':
                    if (cursor > 0) {
                        sb.deleteCharAt(cursor - 1);
                        cursor--;
                    }
                    break;
                case 'P':
                    char ch = st.nextToken().charAt(0);
                    sb.insert(cursor, ch);
                    cursor++;
                    break;
            }
        }
        
        System.out.println(sb.toString());
    }
}