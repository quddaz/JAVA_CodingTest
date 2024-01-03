import java.util.Arrays;

class Solution {
    public int solution(String dartResult) {
        String temp = dartResult.replaceAll("\\*", "").replaceAll("#", "").replaceAll("10", "W");
        int[] N = new int[temp.length() / 2];
        
        for (int i = 0; i < N.length; i++) {
            char SDT = temp.charAt(i * 2 + 1);

            if (temp.charAt(i * 2) == 'W') {
                N[i] = 10;
            } else {
                N[i] = Character.getNumericValue(temp.charAt(i * 2));
            }
            
            switch (SDT) {
                case 'S':
                    break;
                case 'D':
                    N[i] = (int) Math.pow(N[i], 2);
                    break;
                case 'T':
                    N[i] = (int) Math.pow(N[i], 3);
                    break;
            }
        }
        
        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            int n = c == '*' ? 2 : c == '#' ? -1 : 1;
            
            if (i == 2) {
                N[0] *= n;
            } else if (i == dartResult.length() - 1) {
                N[2] *= n;
                if (c == '*') {
                    N[1] *= n;
                }
            } else {
                N[1] *= n;
                if (c == '*') {
                    N[0] *= n;
                }
            }
        }
        
        return Arrays.stream(N).sum();
    }
}