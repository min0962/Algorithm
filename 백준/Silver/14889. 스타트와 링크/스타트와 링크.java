import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, min = Integer.MAX_VALUE;
	static StringBuilder sb;
	static int[][] arr;
	static boolean[] tf;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		tf = new boolean[n];
		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0);

		System.out.println(min);

	}

	private static void dfs(int depth, int idx) {
		if (depth == n / 2) {
			int sTeam = 0;
			int lTeam = 0;
			for (int i = 0; i < n - 1; i++) {
				for (int j = i + 1; j < n; j++) {
					if (tf[i] && tf[j]) {
						sTeam += arr[i][j];
						sTeam += arr[j][i];
					} else if (!tf[i] && !tf[j]) {
						lTeam += arr[i][j];
						lTeam += arr[j][i];
					}
				}
			}
			int result = Math.abs(sTeam - lTeam);
			if (result == 0) {
				System.out.println(0);
				System.exit(0);
			}
			if (min > result) {
				min = result;
			}
			return;
		}

		for (int i = idx; i < n; i++) {
			if (!tf[i]) {
				tf[i] = true;
				dfs(depth + 1, i + 1);
				tf[i] = false;
			}
		}

	}

}