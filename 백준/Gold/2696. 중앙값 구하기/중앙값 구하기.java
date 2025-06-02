import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			int m = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			PriorityQueue<Integer> minHeap = new PriorityQueue<>();


			StringBuilder sb = new StringBuilder();
			int count = 0;

			for (int j = 1; j <= m; j++) {
				int val = Integer.parseInt(st.nextToken());
				minHeap.add(val);
				if (j % 2 == 1) {
					ArrayList<Integer> arr = new ArrayList<>();
					for (int k = 0; k < j / 2; k++) {
						arr.add(minHeap.poll());
					}
					sb.append(minHeap.peek()).append(" ");
					minHeap.addAll(arr);
					count++;
					if(count % 10 == 0) {
						sb.append("\n");
					}
				}
				if (j % 10 == 0) {
					st = new StringTokenizer(br.readLine());
				}
			}
			System.out.println(count + "\n" + sb);
		}

	}

}