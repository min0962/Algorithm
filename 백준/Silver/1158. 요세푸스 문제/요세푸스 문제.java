import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		sb.append("<");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			q.offer(i);
		}

		while(q.size() != 1) {
			for (int i = 0; i < k-1; i++){
				q.offer(q.poll());
			}
			sb.append(q.poll() + ", ");
		}
		sb.append(q.poll() + ">");

		System.out.println(sb);

	}
}