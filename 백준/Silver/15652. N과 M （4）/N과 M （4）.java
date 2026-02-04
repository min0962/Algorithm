import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		List<Integer> list = new ArrayList<>();
		dfs(n, m, list, 0, 1);

	}

	private static void dfs(int n, int m, List<Integer> list, int cnt, int last) {
		if (cnt == m) {
			StringBuilder sb = new StringBuilder();
			for (int i : list) {
				sb.append(i).append(" ");
			}
			System.out.println(sb);
			return;
		}

		for (int i = last; i <= n; i++) {
			list.add(i);
			dfs(n, m, list, cnt + 1, i);
			list.remove(list.size() - 1);
		}
	}
}