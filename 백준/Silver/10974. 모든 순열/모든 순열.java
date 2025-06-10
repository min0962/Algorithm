import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static int n;
	static StringBuilder sb;
	static ArrayList<Integer> list;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		list = new ArrayList<>();

		dfs();

		System.out.println(sb);

	}

	private static void dfs() {

		if (list.size() == n) {
			for (int i : list) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (!list.contains(i)) {
				list.add(i);
				dfs();
				list.remove(Integer.valueOf(i));
			}
		}

	}

}