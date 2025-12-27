import java.util.*;

class Solution {
    static Map<String, List<String>> m;
    static String[] result;
    static boolean found;

    public String[] solution(String[][] tickets) {
        m = new HashMap<>();

        for (String[] ticket : tickets) {
            m.computeIfAbsent(ticket[0], k -> new ArrayList<>()).add(ticket[1]);
        }

        for (List<String> graph : m.values()) {
            Collections.sort(graph);
        }

        List<String> route = new ArrayList<>();
        route.add("ICN");

        found = false;
        dfs("ICN", route, tickets.length + 1);

        return result;
    }

    private void dfs(String airport, List<String> route, int targetSize) {
        if (route.size() == targetSize) {
            result = route.toArray(new String[0]);
            found = true;
            return;
        }

        if (!m.containsKey(airport)) return;

        List<String> destinations = m.get(airport);
        for (int i = 0; i < destinations.size(); i++) {
            if (found) return;

            String next = destinations.remove(i);
            route.add(next);

            dfs(next, route, targetSize);

            route.remove(route.size() - 1); 
            destinations.add(i, next);
        }
    }
}
