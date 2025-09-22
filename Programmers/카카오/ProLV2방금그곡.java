import java.util.*;

public class Solution {
    public String solution(String m, String[] musicinfos) {
        m = normalize(m);
        String answer = "(None)";
        int maxPlayTime = -1;

        for (int idx = 0; idx < musicinfos.length; idx++) {
            String[] parts = musicinfos[idx].split(",", 4);
            int start = toMinute(parts[0]);
            int end = toMinute(parts[1]);
            int playTime = end - start;
            String title = parts[2];
            String melody = normalize(parts[3]);

            if (melody.length() == 0 || playTime <= 0) continue;

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < playTime; i++) {
                sb.append(melody.charAt(i % melody.length()));
            }
            String played = sb.toString();

            if (played.contains(m)) {
                if (playTime > maxPlayTime) {
                    maxPlayTime = playTime;
                    answer = title;
                }
            }
        }

        return answer;
    }

    private int toMinute(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }

    private String normalize(String s) {
        return s.replace("C#", "c")
                .replace("D#", "d")
                .replace("F#", "f")
                .replace("E#", "e")
                .replace("G#", "g")
                .replace("B#", "b")
                .replace("A#", "a");
    }
}