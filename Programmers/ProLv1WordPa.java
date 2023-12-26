class Solution {
    static public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();

        int[] x = new int[10];
        int[] y = new int[10];
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < X.length(); i++) {
            int temp = X.charAt(i) - '0';
            x[temp]++;
        }
        for (int i = 0; i < Y.length(); i++) {
            int temp = Y.charAt(i) - '0';
            y[temp]++;
        }

        for (int i = 9; i >= 0; i--) {
            if (x[i] != 0 && y[i] != 0) {
                for (int j = 0; j < Math.min(x[i], y[i]); j++) list.add(i);
            }
        }

        if (list.size() == 0) {
            return "-1";
        } else if (list.get(0) == 0) {
            return "0";
        }

        for (int i : list) {
            answer.append(i);
        }

        return answer.toString();
    }

}
class Solution {
    public String solution(String X, String Y) {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < Y.length(); i++) {
            char yChar = Y.charAt(i);
            for (int j = 0; j < X.length(); j++) {
                char xChar = X.charAt(j);
                if (xChar == yChar) {
                    answer.add(Character.getNumericValue(xChar));
                    X = X.substring(0, j) + X.substring(j + 1); // 중복 방지
                    break;
                }
            }
        }

        if (answer.isEmpty()) {
            return "-1";
        } else {
            Collections.sort(answer, Collections.reverseOrder());
            StringBuilder result = new StringBuilder();
            answer.forEach(result::append);

            if (result.charAt(0) == '0') {
                return "0";
            } else {
                return result.toString();
            }
        }
    }
}
