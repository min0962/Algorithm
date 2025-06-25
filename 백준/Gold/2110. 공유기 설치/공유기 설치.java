import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n, c;
	static int[] x;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		x = new int[n];

		for (int i = 0; i < n; i++) {
			x[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(x);
		int lo = -1;
		int hi = x[n - 1] + 1;

		while (lo + 1 < hi) {
			int mid = (lo + hi) / 2;
			if (check(mid)) {
				lo = mid;
			} else {
				hi = mid;
			}
		}

		System.out.println(lo);

	}

	private static boolean check(int mid) {
		int count = 1;
		int j = 0;
		for (int i = 1; i < n; i++) {
			if (x[i] - x[j] >= mid) {
				count++;
				j = i;
			}
		}
		return count >= c;
	}

}