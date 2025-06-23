import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			v[i] = Integer.parseInt(st.nextToken());
		}
		int lo = 0;
		int hi = 1000000000;
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
		Long sum = 0L;
		for (int i = 0; i < n; i++) {
			if (v[i] > mid) {
				sum += v[i] - mid;
			}
		}
		return sum >= m;
	}

}