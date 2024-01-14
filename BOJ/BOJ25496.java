import java.util.Arrays;
import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int P = sc.nextInt();
        int N = sc.nextInt();
        int[] arr = new int[N];
        int count = 0;

        for(int i = 0; i < N ; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        for(Integer num : arr){
            if(P < 200){
                count++;
                P += num;
            }
            else
                break;
        }
        System.out.println(count);
    }
}