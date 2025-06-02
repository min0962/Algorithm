import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		Map<String, Integer> map = new HashMap<>();
		List<String> list = new LinkedList<>();
		int total = 0;
		while ((str = br.readLine()) != null) {
			total++;
			if(map.containsKey(str)){
				map.put(str,map.get(str) + 1);
			} else {
				map.put(str, 1);
				list.add(str);
			}
		}
		Collections.sort(list);
		for (String key : list) {
			double p = (double)map.get(key) / total * 100;
			System.out.printf("%s %.4f\n", key, p);
		}

	}

}