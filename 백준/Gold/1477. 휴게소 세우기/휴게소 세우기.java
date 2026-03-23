import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int[] arr = new int[n + 2];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		arr[n] = 0;
		arr[n + 1] = L;
		Arrays.sort(arr);

		int lo = 0;
		int hi = L;

		while (lo + 1 < hi) {
			int mid = (lo + hi) / 2;
			int sum = 0;
			for (int i = n + 1; i > 0; i--) {
				sum += (arr[i] - arr[i - 1] - 1) / mid;
			}
			if (sum > m) {
				lo = mid;
			} else {
				hi = mid;
			}
		}
		System.out.println(hi);
	}
}