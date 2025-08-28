import java.io.*;
import java.util.*;

public class Main {
    public static class State {
        String[] rods;
        int count;
        State(String a, String b, String c, int count) {
            this.rods = new String[]{a, b, c};
            this.count = count;

        }
        String encode() {
            return rods[0] + "|" + rods[1] + "|" + rods[2];
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = "";
        String b = "";
        String c = "";

        StringTokenizer st = new StringTokenizer(br.readLine());
        int temp = Integer.parseInt(st.nextToken());
        if(temp != 0)
            a = st.nextToken();
        st = new StringTokenizer(br.readLine());
        temp = Integer.parseInt(st.nextToken());
        if(temp != 0)
            b = st.nextToken();
        st = new StringTokenizer(br.readLine());
        temp = Integer.parseInt(st.nextToken());
        if(temp != 0)
            c = st.nextToken();


        Queue<State> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        State start =  new State(a, b, c, 0);
        q.add(start);
        visited.add(start.encode());

        while (!q.isEmpty()) {
            State cur = q.poll();

            if (check(cur)) {
                System.out.println(cur.count);
                return;
            }

            for (int i = 0; i < 3; i++) {
                if (cur.rods[i].isEmpty()) continue;
                char top = cur.rods[i].charAt(cur.rods[i].length()-1);
                for (int j = 0; j < 3; j++) {
                    if (i == j) continue;

                    String[] nextRods = cur.rods.clone();
                    nextRods[i] = nextRods[i].substring(0, nextRods[i].length()-1);
                    nextRods[j] = nextRods[j] + top;

                    State next = new State(nextRods[0], nextRods[1], nextRods[2], cur.count+1);
                    String code = next.encode();
                    if (!visited.contains(code)) {
                        visited.add(code);
                        q.add(next);
                    }
                }
            }
        }
        System.out.println(-1);
    }

    public static boolean check(State s){
        String temp[] = s.rods.clone();

        String a = temp[0].replace("A", "");
        String b = temp[1].replace("B", "");
        String c = temp[2].replace("C", "");

        if(!a.equals("")) return false;
        if(!b.equals("")) return false;
        if(!c.equals("")) return false;

        return true;
    }
}