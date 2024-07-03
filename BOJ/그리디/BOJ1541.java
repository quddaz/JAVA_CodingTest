import java.io.*;
import java.util.*;


public class Main {
    // 숫자와 연산자를 저장할 큐
    static Queue<Integer> numbers = new LinkedList<>();
    static Queue<Character> operators = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String tmp = "";
        
        // 수식에서 숫자와 연산자를 분리
        for (char ch : input.toCharArray()) {
            if (ch == '+' || ch == '-') {
                numbers.add(Integer.parseInt(tmp));
                tmp = "";
                operators.add(ch);
            } else {
                tmp += ch;
            }
        }
        // 마지막 숫자를 큐에 추가
        numbers.add(Integer.parseInt(tmp));
        solve();
        
    }
    public static void solve(){
        int result = numbers.poll();

        boolean flag = false;
        while(!numbers.isEmpty()){
            char operator = operators.poll();
            int num = numbers.poll();
            if(operator == '-')
                flag = true;
            if(flag)
                result -= num;
            else
                result += num;
        }
        System.out.println(result);
    }
}


/*
세준이는 양수와 +, -, 그리고 괄호를 가지고 식을 만들었다.
그리고 나서 세준이는 괄호를 모두 지웠다.

그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.

괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.
 */