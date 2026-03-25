import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[] arr, val;
	static boolean[] visited;
	static StringBuilder result;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		visited = new boolean[n];
		val = new int[n];
		result = new StringBuilder();

		dfs(0, 0);

		System.out.println(result);

	}

	private static void dfs(int next, int depth) {
		if (depth == m) {
			for (int i = 0; i < m; i++) {
				result.append(val[i]).append(" ");
			}
			result.append("\n");
			return;
		}

		for (int i = next; i < n; i++) {
			if (i != 0 && arr[i] == arr[i - 1] && !visited[i - 1]) {
				continue;
			}
			if (!visited[i]) {
				visited[i] = true;
				val[depth] = arr[i];
				dfs(i + 1, depth + 1);
				visited[i] = false;
			}
		}

	}
}