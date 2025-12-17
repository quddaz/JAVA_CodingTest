import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] need = new int[4];  
    static int[] count = new int[4];  
    static int satisfied = 0;    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        char[] dna = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            need[i] = Integer.parseInt(st.nextToken());
            if (need[i] == 0) satisfied++;
        }

        int answer = 0;

        for (int i = 0; i < P; i++) {
            add(dna[i]);
        }

        if (satisfied == 4) answer++;

        for (int i = P; i < S; i++) {
            add(dna[i]);
            remove(dna[i - P]);

            if (satisfied == 4) answer++;
        }

        System.out.println(answer);
    }

    static void add(char c) {
        int idx = toIndex(c);
        count[idx]++;
        if (count[idx] == need[idx]) {
            satisfied++;
        }
    }

    static void remove(char c) {
        int idx = toIndex(c);
        if (count[idx] == need[idx]) {
            satisfied--;
        }
        count[idx]--;
    }

    static int toIndex(char c) {
        if (c == 'A') return 0;
        if (c == 'C') return 1;
        if (c == 'G') return 2;
        return 3; // 'T'
    }
}
