import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int caseNum = 1;
        while (C-- > 0) {
            char[] S = br.readLine().toCharArray();
            char[] T = br.readLine().toCharArray();
            int n = S.length;

            int c10 = 0; // S[i] = '1', T[i] = '0'
            int c01 = 0; // S[i] = '0', T[i] = '1'
            int a1 = 0;  // S[i] = '?', T[i] = '1'
            int a0 = 0;  // S[i] = '?', T[i] = '0'

            for (int i = 0; i < n; i++) {
                if (S[i] == '1' && T[i] == '0') {
                    c10++;
                } else if (S[i] == '0' && T[i] == '1') {
                    c01++;
                } else if (S[i] == '?' && T[i] == '1') {
                    a1++;
                } else if (S[i] == '?' && T[i] == '0') {
                    a0++;
                }
            }

            if (c10 > c01 + a1) {
                sb.append("Case ").append(caseNum++).append(": ").append("-1\n");
            } else {
                int extra_cost_for_c10 = Math.max(0, c10 - c01);
                int total_cost = a0 + a1 + c01 + extra_cost_for_c10;
                sb.append("Case ").append(caseNum++).append(": ").append(total_cost).append("\n");
            }
        }

        System.out.print(sb);
    }
}