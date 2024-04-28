import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String, String> map = new HashMap<>();
        NavigableSet<String> set = new TreeSet<>();

        int n = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < n; i++){    
            String str = bufferedReader.readLine();
            String[] arr = str.split(" ");
            map.put(arr[0], arr[1]);
        }

        for (Map.Entry<String, String> entry : map.entrySet()){
            if (entry.getValue().equals("enter")){
                set.add(entry.getKey());
            }
        }

        Iterator<String> iterator = set.descendingIterator();
        while (iterator.hasNext()){
            bufferedWriter.write(iterator.next() + "\n");
            bufferedWriter.flush();
        }
        bufferedWriter.close();
    }
}