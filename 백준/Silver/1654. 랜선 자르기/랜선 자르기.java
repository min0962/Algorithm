import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int k, n;
	static int[] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		v = new int[k];

		for (int i = 0; i < k; i++) {
			v[i] = Integer.parseInt(br.readLine());
		}

		long lo = 0;
		long hi = Integer.MAX_VALUE + 1L;

		while (lo + 1 < hi) {
			long mid = (lo + hi) / 2;
			if (check(mid)) {
				lo = mid;
			} else {
				hi = mid;
			}
		}

		System.out.println(lo);

	}

	private static boolean check(long mid) {
		long count = 0;
		for (int i : v) {
			count += i / mid;
		}
		return count >= n;
	}

}