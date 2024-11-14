import java.util.*;

class Solution {
    Set<Set<String>> result = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        List<List<String>> possibleBans = new ArrayList<>();
        
        // 각 banned_id에 대해 매칭 가능한 user_id 리스트 생성
        for (String ban : banned_id) {
            List<String> matchingUsers = new ArrayList<>();
            for (String user : user_id) {
                if (ban.length() == user.length() && valid(user, ban)) {
                    matchingUsers.add(user);
                }
            }
            possibleBans.add(matchingUsers);
        }
        
        findCombinations(possibleBans, new HashSet<>(), 0);
        
        return result.size();
    }
    
    private void findCombinations(List<List<String>> possibleBans, Set<String> selected, int index) {
        if (index == possibleBans.size()) {
            result.add(new HashSet<>(selected));
            return;
        }
        
        for (String user : possibleBans.get(index)) {
            if (!selected.contains(user)) {
                selected.add(user);
                findCombinations(possibleBans, selected, index + 1);
                selected.remove(user);
            }
        }
    }
    private boolean valid(String user, String ban) {
        for (int i = 0; i < user.length(); i++) {
            if (ban.charAt(i) != '*' && user.charAt(i) != ban.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
