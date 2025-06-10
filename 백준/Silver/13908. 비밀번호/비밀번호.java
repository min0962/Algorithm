import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m, count = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		if (m == 0) {
			System.out.println((int)Math.pow(10, n));
			return;
		}

		st = new StringTokenizer(br.readLine());
		boolean[] arr = new boolean[10];
		for (int i = 0; i < m; i++) {
			arr[Integer.parseInt(st.nextToken())] = true;
		}

		dfs(0, 0, arr);

		System.out.println(count);

	}

	private static void dfs(int depth, int num, boolean[] arr) {

		if (depth == n) {
			if (num == m) {
				count++;
			}
			return;
		}

		for (int i = 0; i < 10; i++) {
			if (arr[i]) {
				arr[i] = false;
				dfs(depth + 1, num + 1, arr);
				arr[i] = true;

			} else {
				dfs(depth + 1, num, arr);
			}
		}

	}

}