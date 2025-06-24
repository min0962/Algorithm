import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[] a, b, c, d, ab;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		a = new int[n];
		b = new int[n];
		c = new int[n];
		d = new int[n];
		ab = new int[n * n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
			c[i] = Integer.parseInt(st.nextToken());
			d[i] = Integer.parseInt(st.nextToken());
		}

		int idx = 0;
		for (int i : a) {
			for (int j : b) {
				ab[idx++] = i + j;
			}
		}
		Arrays.sort(ab);

		long count = 0;
		for (int i : c) {
			for (int j : d) {
				int val = -(i + j);
				count += upperBound(val) - lowerBound(val);
			}
		}

		System.out.println(count);

	}

	private static int lowerBound(int x) {
		int lo = -1;
		int hi = n * n;
		while (lo + 1 < hi) {
			int mid = (lo + hi) / 2;
			if (!(ab[mid] >= x)) {
				lo = mid;
			} else {
				hi = mid;
			}
		}
		return hi;
	}

	private static int upperBound(int x) {
		int lo = -1;
		int hi = n * n;
		while (lo + 1 < hi) {
			int mid = (lo + hi) / 2;
			if (!(ab[mid] > x)) {
				lo = mid;
			} else {
				hi = mid;
			}
		}
		return hi;
	}

}