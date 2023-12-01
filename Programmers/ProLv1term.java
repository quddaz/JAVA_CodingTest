import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        LocalDate localToday = getLocalDate(today);

        HashMap<String, Integer> termsMap = new HashMap<>(); //terms를 key-value로 저장
        List<Integer> index = new ArrayList<>(); //만료한 날짜 인덱스 저장

        for (String term : terms) { //해시 맵 초기화
            String[] tempTerm = term.split(" ");
            termsMap.put(tempTerm[0], Integer.parseInt(tempTerm[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] tempPrivacy = privacies[i].split(" ");
            LocalDate localPrivacy = getLocalDate(tempPrivacy[0]);

            if (localToday.isAfter(localPrivacy.plusMonths(termsMap.get(tempPrivacy[1])).minusDays(1))) {
                index.add(i + 1); 
            }
        }

        int[] answer = index.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }

    public LocalDate getLocalDate(String day) { //String 날짜를 LocalDate 형식으로 변환 
        String[] localDay = day.split("\\.");
        return LocalDate.of(Integer.parseInt(localDay[0]), Integer.parseInt(localDay[1]), Integer.parseInt(localDay[2]));
    }
}