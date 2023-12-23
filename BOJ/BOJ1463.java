import java.util.Scanner;

public class Main{
	static int[]d;
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		d = new int[num+1];
		System.out.println(cal(num));
		sc.close();
	}
	
	public static int cal(int n) {
		
		//끝나는 지점부터 설정!
		if(n < 2)
			return 0;
		
		//이미 값이 들어있으면 또 계산 할 필요 없이 그냥 그대로 보내!
		if(d[n]>0) {
			return d[n];
		}
		
		//그게 아니면 계산 시작.
		
		//무조건 실행가능한애.
		d[n] = cal(n-1)+1;
	
		//짝수일경우만 실행되는 애.
		if(n%2 == 0) {
			int tmp = cal(n/2)+1;
			if(d[n] > tmp)
				d[n]=tmp;
		}
		
		//3으로 나눠지는경우만 실행되는 애.
		if(n % 3==0){
			int tmp = cal(n/3)+1;
			if(d[n] > tmp)
				d[n]=tmp;
		}
		return d[n];
	}
	
}