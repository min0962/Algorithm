import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static StringBuilder sb;
	static String str;
	static char[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < n; tc++) {
			str = br.readLine();
			arr = str.toCharArray();
			Arrays.sort(arr);
			sb = new StringBuilder();
			visited = new boolean[arr.length];

			dfs(0, new char[arr.length]);

			System.out.print(sb);
		}
	}

	private static void dfs(int depth, char[] result) {

		if (depth == str.length()) {
			for (char c : result) {
				sb.append(c);
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (visited[i]) {
				continue;
			}
			if (i > 0 && arr[i] == arr[i - 1] && !visited[i - 1]) {
				continue;
			}
			visited[i] = true;
			result[depth] = arr[i];
			dfs(depth + 1, result);
			visited[i] = false;
		}
	}
}