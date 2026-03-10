import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Main {

	static String str;
	static List<int[]> pairs;
	static Set<String> result;
	static boolean[] removed;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		str = br.readLine();

		pairs = new ArrayList<>();
		result = new HashSet<>();
		removed = new boolean[str.length()];
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				stack.push(i);
			} else if (str.charAt(i) == ')') {
				pairs.add(new int[] {stack.pop(), i});
			}
		}

		dfs(0);

		List<String> list = new ArrayList<>(result);
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		for (String s : list) {
			sb.append(s).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int depth) {
		if (depth == pairs.size()) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < str.length(); i++) {
				if (!removed[i]) {
					sb.append(str.charAt(i));
				}
			}
			if (!str.equals(sb.toString())) {
				result.add(sb.toString());
			}
			return;
		}

		int open = pairs.get(depth)[0];
		int close = pairs.get(depth)[1];
		removed[open] = true;
		removed[close] = true;
		dfs(depth + 1);

		removed[open] = false;
		removed[close] = false;
		dfs(depth + 1);

	}

}