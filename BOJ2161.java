import java.util.Scanner;
import java.util.Vector;

class Main{
    public static void main(String[] args) {
        Scanner std = new Scanner(System.in);
        int N = std.nextInt();
        int arr[] = new int[N];
        Vector<Integer> numArr = new Vector<>();
        for(int i = 0; i < N; i++){
            numArr.add(i+1);
        }
        for(int i = 0; i < N; i++){
            arr[i] = numArr.get(0);
            numArr.remove(0);
            if(numArr.size()> 1){
                int tmp = numArr.get(0);
                numArr.remove(0);
                numArr.add(tmp);
            }
        }
        for(Integer num : arr){
            System.out.print(num+" ");
        }
    }
}