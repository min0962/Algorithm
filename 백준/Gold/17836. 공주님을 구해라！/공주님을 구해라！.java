import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, t;
	static int[][] arr;
	static boolean[][][] visited;
	static int[] xx = {0, 0, 1, -1};
	static int[] yy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		arr = new int[n + 1][m + 1];
		visited = new boolean[n + 1][m + 1][2];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {1, 1, 0, 0});
		visited[1][1][0] = true;

		while (!queue.isEmpty()) {
			int[] val = queue.poll();
			int x = val[0];
			int y = val[1];
			int depth = val[2];
			int sword = val[3];
			if (x == n && y == m) {
				System.out.println(depth);
				return;
			}
			if (depth > t) {
				System.out.println("Fail");
				return;
			}
			if (arr[x][y] == 2) {
				sword = 1;
			}
			for (int i = 0; i < 4; i++) {
				int nextX = x + xx[i];
				int nextY = y + yy[i];
				if (nextX <= 0 || nextX > n || nextY <= 0 || nextY > m) {
					continue;
				}
				if (arr[nextX][nextY] == 1 && sword != 1) {
					continue;
				}
				if (!visited[nextX][nextY][sword]) {
					queue.add(new int[] {nextX, nextY, depth + 1, sword});
					visited[nextX][nextY][sword] = true;
				}
			}
		}
		System.out.println("Fail");
	}
}
