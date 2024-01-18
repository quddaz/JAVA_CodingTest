import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr1 = new int[M];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = sc.nextInt();
        }

        // 내림차순 정렬
        Arrays.sort(arr1);
        for (int i = 0; i < arr1.length / 2; i++) {
            int temp = arr1[i];
            arr1[i] = arr1[arr1.length - 1 - i];
            arr1[arr1.length - 1 - i] = temp;
        }

        int counter = N > M ? M : N; // 반복횟수 
        int Max = 0;
        int MaxCount = 0;
        for (int i = 0; i < counter; i++) {
            int currentCount = arr1[i] * (i + 1);
            if (MaxCount < currentCount) {
                Max = arr1[i];
                MaxCount = currentCount;
            }
        }
        System.out.println(Max + " " + MaxCount);
    }
}