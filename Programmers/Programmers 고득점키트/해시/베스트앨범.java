import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genrePlayCount = new HashMap<>();
        Map<String, List<int[]>> genreSongs = new HashMap<>();
        
        // 각 노래의 장르와 재생 수 처리
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            // 1. 장르별 총 재생 수 누적
            genrePlayCount.put(genre, genrePlayCount.getOrDefault(genre, 0) + play);
            
            // 2. 장르별 노래 리스트에 추가 (고유 번호와 재생 수)
            genreSongs.computeIfAbsent(genre, k -> new ArrayList<>()).add(new int[] {play, i});
        }
        
        List<String> genreRanking = new ArrayList<>(genrePlayCount.keySet());
        genreRanking.sort((g1, g2) -> genrePlayCount.get(g2) - genrePlayCount.get(g1));
        
        List<Integer> result = new ArrayList<>();
        
        // 4. 각 장르별로 많이 재생된 곡을 두 개까지 선택
        for (String genre : genreRanking) {
            List<int[]> songs = genreSongs.get(genre);
            
            // 재생 수가 많고, 재생 수가 같으면 고유 번호가 작은 순으로 정렬
            songs.sort((a, b) -> b[0] != a[0] ? b[0] - a[0] : a[1] - b[1]);
            
            for (int i = 0; i < Math.min(songs.size(), 2); i++) {
                result.add(songs.get(i)[1]);
            }
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}

// 1. 장르별 노래 재생 수
// 2. 장르 내 노래 재생 수
// 3. 같다면 고유 번호 순
// 4. 최대 2개의 노래 선택