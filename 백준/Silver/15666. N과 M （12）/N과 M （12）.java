import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[] arr, result;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		Set<Integer> set = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		int idx = 0;
		arr = new int[set.size()];
		for (int i : set) {
			arr[idx++] = i;
		}
		Arrays.sort(arr);
		result = new int[m];
		dfs(0, 0);
	}

	private static void dfs(int depth, int next) {
		if (depth == m) {
			StringBuilder sb = new StringBuilder();
			for (int i : result) {
				sb.append(i).append(" ");
			}
			System.out.println(sb);
			return;
		}

		for (int i = next; i < arr.length; i++) {
			result[depth] = arr[i];
			dfs(depth + 1, i);
		}
	}
}