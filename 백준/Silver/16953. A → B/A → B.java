import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		Queue<long[]> queue = new LinkedList<>();
		queue.offer(new long[] {a, 0});

		while (!queue.isEmpty()) {
			long[] temp = queue.poll();
			long val = temp[0];
			long depth = temp[1];

			if (val == b) {
				System.out.println(depth + 1);
				return;
			} else if (val > b) {
				continue;
			}

			long func1 = val * 2;
			queue.offer(new long[] {func1, depth + 1});

			long func2 = val * 10 + 1;
			queue.offer(new long[] {func2, depth + 1});
		}
		System.out.println(-1);
	}
}