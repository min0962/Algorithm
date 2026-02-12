import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] crane = new int[n];
		for (int i = 0; i < n; i++) {
			crane[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(crane);

		int m = Integer.parseInt(br.readLine());
		List<Integer> box = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			box.add(Integer.parseInt(st.nextToken()));
		}
		box.sort(Comparator.reverseOrder());

		if (crane[n - 1] < box.get(0)) {
			System.out.println(-1);
			return;
		}

		int time = 0;
		while (!box.isEmpty()) {
			time++;
			for (int i = n - 1; i >= 0; i--) {
				for (int j = 0; j < box.size(); j++) {
					if (box.get(j) <= crane[i]) {
						box.remove(j);
						break;

					}
				}
			}
		}
		System.out.println(time);
	}
}