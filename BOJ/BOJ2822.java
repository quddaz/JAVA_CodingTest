
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		HashMap<Integer, Integer> hashmap = new HashMap<>();
		int summ=0;
		
		for (int i=0; i<8;i++) {
			hashmap.put(Integer.parseInt(br.readLine()), i); 
		}

		List<Integer> keySet = new ArrayList<>(hashmap.keySet()); 
		
		Collections.sort(keySet);
 
		List<Integer> ansL = new ArrayList<>();
		
		for (int i=3; i<=7; i++) {
			ansL.add(hashmap.get(keySet.get(i))+1);
			summ+=keySet.get(i);
		}

		Collections.sort(ansL);

		System.out.println(summ);
		for (int i=0; i<5;i++) System.out.print(ansL.get(i)+" ");
		
    }

}

