public class Main {

	public static void main(String[] args) {
		int [] arry = new int[10000];
		int count = 1; 
		
		while(count<10000) {
			if(d(count)<10000) { 
				arry[d(count)]++;
			}
			count ++; 
		}
		
		for(int i=1; i<10000; i++) {
			if(arry[i] == 0) {
				System.out.println(i);
			}
		}
		
	}
	
	public static int d(int num) { 
		int org = num;
		
		while(num>0) {
			org += (num%10);
			num /= 10; 
		}
		return org; 
	}
}