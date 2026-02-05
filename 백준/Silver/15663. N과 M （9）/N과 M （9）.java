import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[] arr, result;
	static boolean[] visited;

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

		result = new int[m];
		visited = new boolean[n];
		dfs(0);

	}

	private static void dfs(int depth) {

		if (depth == m) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < m; i++) {
				sb.append(result[i]).append(" ");
			}
			System.out.println(sb);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				if (i != 0 && arr[i] == arr[i - 1] && !visited[i - 1]) {
					continue;
				}
				result[depth] = arr[i];
				visited[i] = true;
				dfs(depth + 1);
				visited[i] = false;
			}

		}

	}

}