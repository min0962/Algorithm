import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] xx = {0, 0, 1, -1};
	static int[] yy = {1, -1, 0, 0};
	static int n, m;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int result = 0;
		while (true) {
			int[][] tempArr = new int[n][m];
			int zeroCnt = 0;
			for (int i = 1; i < n - 1; i++) {
				for (int j = 1; j < m - 1; j++) {
					if (arr[i][j] == 0) {
						zeroCnt++;
						continue;
					}
					int cnt = 0;
					for (int k = 0; k < 4; k++) {
						int nextX = i + xx[k];
						int nextY = j + yy[k];

						if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) {
							continue;
						}

						if (arr[nextX][nextY] == 0) {
							cnt++;
						}

					}
					tempArr[i][j] = Math.max(arr[i][j] - cnt, 0);
				}
			}
			result++;

			if (zeroCnt == (n - 2) * (m - 2)) {
				System.out.println(0);
				return;
			}

			arr = tempArr;

			int cnt = 0;
			boolean[][] visited = new boolean[n][m];
			for (int i = 1; i < n - 1; i++) {
				for (int j = 1; j < m - 1; j++) {
					if (arr[i][j] == 0 || visited[i][j]) {
						continue;
					}
					dfs(i, j, arr, visited);
					cnt++;
				}
			}

			if (cnt >= 2) {
				System.out.println(result);
				return;
			}

		}

	}

	private static void dfs(int i, int j, int[][] arr, boolean[][] visited) {

		for (int k = 0; k < 4; k++) {
			int nextX = i + xx[k];
			int nextY = j + yy[k];

			if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) {
				continue;
			}
			if (arr[nextX][nextY] == 0) {
				continue;
			}
			if (!visited[nextX][nextY]) {
				visited[nextX][nextY] = true;
				dfs(nextX, nextY, arr, visited);
			}
		}

	}

}