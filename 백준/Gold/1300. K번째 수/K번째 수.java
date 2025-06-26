import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int n, k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());

		int lo = 0;
		int hi = (int)Math.pow(10, 9) + 1;

		while (lo + 1 < hi) {
			int mid = (lo + hi) / 2;
			if (check(mid)) {
				lo = mid;
			} else {
				hi = mid;
			}
		}

		System.out.println(hi);

	}

	private static boolean check(int mid) {
		int count = 0;

		for (int i = 1; i <= n; i++) {
			count += Math.min(mid / i, n);
		}
		return count < k;
	}

}