import java.util.Scanner;

public class HanSu {
    // 주어진 숫자가 한수인지 확인하는 메서드
    public static boolean isHanSu(int number) {
        // 숫자가 100 미만이면 무조건 한수
        if (number < 100) {
            return true;
        }
        
        // 숫자가 100 이상이면 각 자리 숫자의 차이를 확인
        int first = number / 100;       // 백의 자리
        int second = (number / 10) % 10; // 십의 자리
        int third = number % 10;        // 일의 자리
        
        return (first - second) == (second - third);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;
        
        // 1부터 N까지의 모든 숫자에 대해 한수인지 확인
        for (int i = 1; i <= N; i++) {
            if (isHanSu(i)) {
                count++;
            }
        }
        
        System.out.println(count);
        sc.close();
    }
}
