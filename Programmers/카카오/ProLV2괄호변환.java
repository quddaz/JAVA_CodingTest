class Solution {
    public String solution(String p) {
        if (p.isEmpty()) return p;

        String[] uv = splitBalanced(p);
        String u = uv[0];
        String v = uv[1];

        if (isCorrect(u)) {
            return u + solution(v);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(solution(v));
            sb.append(")");
            sb.append(reverse(u.substring(1, u.length() - 1)));
            return sb.toString();
        }
    }

    private String[] splitBalanced(String p) {
        int open = 0, close = 0;
        int idx = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') open++;
            else close++;
            if (open == close) {
                idx = i + 1;
                break;
            }
        }
        return new String[]{p.substring(0, idx), p.substring(idx)};
    }

    private boolean isCorrect(String s) {
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') cnt++;
            else cnt--;
            if (cnt < 0) return false;
        }
        return cnt == 0;
    }

    private String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c == '(' ? ')' : '(');
        }
        return sb.toString();
    }
}
