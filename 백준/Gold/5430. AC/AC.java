import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			Deque<String> dq = new ArrayDeque<>();
			boolean reverse = false;
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), ",");
			String val;
			StringBuilder sb = new StringBuilder();

			if (n == 1) {
				val = st.nextToken();
				dq.add(val.substring(1, val.length() - 1));
			} else if (n > 1) {
				for (int j = 0; j < n; j++) {
					val = st.nextToken();
					if (j == 0) {
						dq.add(val.substring(1));
					} else if (j == n - 1) {
						dq.add(val.substring(0, val.length() - 1));
					} else {
						dq.add(val);
					}
				}
			}
			for (int j = 0; j < p.length(); j++) {
				if (p.charAt(j) == 'R') {
					reverse = !reverse;
				} else if (p.charAt(j) == 'D') {
					if (dq.isEmpty()) {
						sb.setLength(0);
						sb.append("error");
						break;
					}
					if (reverse) {
						dq.removeLast();
					} else {
						dq.removeFirst();
					}
				}
			}

			if (!sb.toString().equals("error")) {
				sb.append("[");
				while (!dq.isEmpty()) {
					if (reverse) {
						sb.append(dq.removeLast());
					} else {
						sb.append(dq.removeFirst());
					}
					if(!dq.isEmpty())
						sb.append(",");
				}
				sb.append("]");
			}
			System.out.println(sb);
		}

	}

}