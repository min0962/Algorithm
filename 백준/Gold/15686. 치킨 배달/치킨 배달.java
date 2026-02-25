import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int n, m, min = Integer.MAX_VALUE;
	static List<int[]> home, chicken;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		home = new ArrayList<>();
		chicken = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				int val = Integer.parseInt(st.nextToken());
				if (val == 1) {
					home.add(new int[] {i, j});
				} else if (val == 2) {
					chicken.add(new int[] {i, j});
				}
			}
		}

		List<int[]> list = new ArrayList<>();
		dfs(list, 0);
		System.out.println(min);
	}

	private static void dfs(List<int[]> list, int idx) {
		if (list.size() == m) {
			calc(list);
			return;
		}

		for (int i = idx; i < chicken.size(); i++) {
			list.add(chicken.get(i));
			dfs(list, i + 1);
			list.remove(list.size() - 1);
		}

	}

	private static void calc(List<int[]> list) {
		int total = 0;
		for (int[] i : home) {
			int res = Integer.MAX_VALUE;
			for (int[] chi : list) {
				int val = Math.abs(i[0] - chi[0]) + Math.abs(i[1] - chi[1]);
				res = Math.min(res, val);
			}
			total += res;
		}
		min = Math.min(min, total);
	}

}
