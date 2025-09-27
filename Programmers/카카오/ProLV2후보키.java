import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int solution(String[][] relation) {
        int rowCount = relation.length;
        int colCount = relation[0].length;
        List<Integer> candidateKeys = new ArrayList<>();

        for (int i = 1; i < (1 << colCount); i++) {
            
            boolean isMinimal = true;
            for (int key : candidateKeys) {
                if ((i & key) == key) {
                    isMinimal = false;
                    break;
                }
            }
            if (!isMinimal) {
                continue;
            }

            Set<String> uniqueSet = new HashSet<>();
            for (int r = 0; r < rowCount; r++) {
                StringBuilder sb = new StringBuilder();
                for (int c = 0; c < colCount; c++) {
                    if ((i & (1 << c)) != 0) {
                        sb.append(relation[r][c]).append(",");
                    }
                }
                uniqueSet.add(sb.toString());
            }

            if (uniqueSet.size() == rowCount) {
                candidateKeys.add(i);
            }
        }

        return candidateKeys.size();
    }
}