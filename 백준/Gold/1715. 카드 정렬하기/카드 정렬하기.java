import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}

		int result = 0;

		if (n == 1) {
			System.out.println(0);
			return;
		}

		for (int i = 0; i < n - 1; i++) {
			int num1 = pq.poll();
			int num2 = pq.poll();

			int sum = num1 + num2;
			pq.offer(sum);
			result += sum;
		}
		System.out.println(result);
	}
}