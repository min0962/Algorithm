import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
	static StringBuilder sb;
	static int[] arr;
	static boolean[] tf;
	static ArrayList<Integer> list, op;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		arr = new int[n];
		tf = new boolean[n - 1];
		op = new ArrayList<>();
		list = new ArrayList<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			int j = Integer.parseInt(st.nextToken());
			for (int k = 0; k < j; k++) {
				op.add(i);
			}
		}

		dfs(0);

		System.out.println(max);
		System.out.println(min);

	}

	private static void dfs(int depth) {
		if (depth == op.size()) {
			int sum = arr[0];
			for (int i = 1; i < n; i++) {
				switch (list.get(i-1)) {
					case 0:
						sum += arr[i];
						break;
					case 1:
						sum -= arr[i];
						break;
					case 2:
						sum *= arr[i];
						break;
					case 3:
						if (sum < 0) {
							sum = -(-sum) / arr[i];
						} else {
							sum = sum / arr[i];
						} 
						
						break;
				}
			}
			max = Math.max(max, sum);
			min = Math.min(min, sum);

			return;
		}

		for (int i = 0; i < op.size(); i++) {
			if (!tf[i]) {
				list.add(op.get(i));
				tf[i] = true;
				dfs(depth + 1);
				list.remove(list.size() - 1);
				tf[i] = false;
			}
		}

	}

}