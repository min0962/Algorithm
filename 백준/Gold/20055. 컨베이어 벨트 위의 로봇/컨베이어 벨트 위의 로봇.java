import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] arr = new int[n * 2];
		boolean[] robot = new boolean[n * 2];
		st = new StringTokenizer(br.readLine());
		int zeroCnt = 0;
		for (int i = 0; i < n * 2; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (arr[i] == 0) {
				zeroCnt++;
			}
		}

		int step = 0;
		int start = 0;
		int end = n - 1;

		while (zeroCnt < k) {
			step++;
			start = start == 0 ? n * 2 - 1 : start - 1;
			end = end == 0 ? n * 2 - 1 : end - 1;
			if (robot[end]) {
				robot[end] = false;
			}
			int i = end - 1;
			i = i < 0 ? i + n * 2 : i;
			while (start != i) {
				int next = (i + 1) % (n * 2);
				if (robot[i] && !robot[next] && arr[next] > 0) {
					robot[i] = false;
					robot[next] = true;
					arr[next]--;
					if (arr[next] == 0) {
						zeroCnt++;
					}
				}
				i--;
				i = i < 0 ? i + n * 2 : i;
			}
			if (robot[end]) {
				robot[end] = false;
			}

			if (arr[start] != 0) {
				robot[start] = true;
				arr[start]--;
				if (arr[start] == 0) {
					zeroCnt++;
				}
			}
		}
		System.out.println(step);
	}
}
