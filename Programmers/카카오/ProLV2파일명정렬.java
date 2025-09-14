import java.util.*;

class Solution {
    static class FilePart {
        String head;
        int number;
        String original;
        int index; 

        FilePart(String original, int index) {
            this.original = original;
            this.index = index;

            int i = 0;
            while (i < original.length() && !Character.isDigit(original.charAt(i))) i++;
            head = original.substring(0, i);

            int j = i;
            while (j < original.length() && Character.isDigit(original.charAt(j)) && j - i < 5) j++;
            number = Integer.parseInt(original.substring(i, j));
        }
    }

    public String[] solution(String[] files) {
        List<FilePart> list = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            list.add(new FilePart(files[i], i));
        }

        list.sort((a, b) -> {
            int cmp = a.head.toLowerCase().compareTo(b.head.toLowerCase());
            if (cmp != 0) return cmp;
            cmp = Integer.compare(a.number, b.number);
            if (cmp != 0) return cmp;
            return Integer.compare(a.index, b.index);
        });

        String[] answer = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            answer[i] = list.get(i).original;
        }
        return answer;
    }
}
