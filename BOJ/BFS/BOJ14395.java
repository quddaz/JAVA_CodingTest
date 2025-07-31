import java.io.*;
import java.util.*;

public class Main {
    public static class Node{
        String ops;
        long num;

        Node(String ops, long num){
            this.ops = ops;
            this.num = num;
        }
    }

    static char op[] = {'*','+','-','/'};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        if(n == m){
            System.out.println(0);
            return;
        }

        Set<Long> s = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        q.add(new Node("", n));
        s.add((long)n);

        while(!q.isEmpty()){
            Node cnt = q.poll();

            if(cnt.num == m){
                System.out.println(cnt.ops);
                return;
            }
            for(char o : op){
                long next = calculate(cnt.num, o);
                if(!s.contains(next)){
                    q.add(new Node(cnt.ops + o, next));
                    s.add(next);
                }
            }
        }

        System.out.println(-1);
    }

    public static long calculate(long num, char op){
        long next = 0;
        switch (op) {
            case '*':
                next = num * num;
                break;
            case '+':
                next = num + num;
                break;
            case '-':
                next = num - num;
                break;
            case '/':
                if(num != 0)
                    next = num / num;
                break;
        }
        return next;
    }
}