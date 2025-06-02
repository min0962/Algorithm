import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x == 0) {
				Integer val = maxHeap.poll();
				sb.append(val != null ? val : 0).append("\n");
			} else {
				maxHeap.add(x);
			}
		}

		System.out.println(sb);

	}

}