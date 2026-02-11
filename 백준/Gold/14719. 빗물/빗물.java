import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());

		int[] arr = new int[w];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < w; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int result = 0;
		for (int i = 1; i <= h; i++) {
			boolean leftBlock = false;
			int cnt = 0;
			for (int j = 0; j < w; j++) {
				if (!leftBlock) {
					if (arr[j] >= i) {
						leftBlock = true;
					}
				} else {
					if (arr[j] >= i) {
						result += cnt;
						cnt = 0;
					} else {
						cnt++;
					}
				}
			}
		}
		System.out.println(result);
	}
}