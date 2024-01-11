import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] level = new int[N];
        int result = 0;
        for (int i =0; i <N; i++) 
            level[i] = scanner.nextInt();
        
        for(int i = N-1; i >= 1; i--){
            while(level[i] <= level[i-1]){
                level[i-1]--;
                result++;
            }
        }
        System.out.println(result);
    }
}