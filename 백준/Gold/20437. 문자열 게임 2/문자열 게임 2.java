import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < t; tc++) {
			String w = br.readLine();
			int k = Integer.parseInt(br.readLine());
			Map<Character, Integer> map = new HashMap<>();
			for (int i = 0; i < w.length(); i++) {
				map.put(w.charAt(i), map.getOrDefault(w.charAt(i), 0) + 1);
			}
			int min = w.length() + 1;
			int max = -1;

			for (int i = 0; i < w.length(); i++) {
				if (map.get(w.charAt(i)) < k) {
					continue;
				}
				map.put(w.charAt(i), map.get(w.charAt(i)) - 1);
				int j = 1;
				int idx = i;
				while (j < k) {
					idx = w.indexOf(w.charAt(i), idx + 1);
					j++;
				}
				int d = idx - i + 1;
				min = Math.min(min, d);
				max = Math.max(max, d);
			}
			if (max == -1) {
				System.out.println(-1);
			} else {
				System.out.println(min + " " + max);
			}
		}

	}
}