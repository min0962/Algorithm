import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		int result = -1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int dr = -n + 1; dr < n; dr++) {
					for (int dc = -m + 1; dc < m; dc++) {
						if (dr == 0 && dc == 0) {
							int val = (int)Math.sqrt(arr[i][j]);
							if (val * val == arr[i][j]) {
								result = Math.max(result, arr[i][j]);
							}
							continue;
						}
						int t = 0;
						int newI = i;
						int newJ = j;

						while (newI >= 0 && newI < n && newJ >= 0 && newJ < m) {
							t = t * 10 + arr[newI][newJ];
							int val = (int)Math.sqrt(t);
							if (val * val == t) {
								result = Math.max(result, t);
							}
							newI += dr;
							newJ += dc;
						}

					}
				}
			}
		}
		System.out.println(result);
	}

}