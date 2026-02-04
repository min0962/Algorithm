import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] result = new int[n];

		PriorityQueue<int[]> pq = new PriorityQueue<>(
			Comparator.comparingInt(a -> a[0])
		);

		for (int i = n - 1; i >= 0; i--) {
			while (!pq.isEmpty() && arr[i] >= pq.peek()[0]) {
				result[pq.poll()[1]] = i + 1;
			}
			pq.offer(new int[] {arr[i], i});
		}
		StringBuilder sb = new StringBuilder();
		for (int i : result) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	}
}