import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int max = 0;
	static ArrayList<Integer> t;
	static ArrayList<Integer> p;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		t = new ArrayList<>();
		p = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			t.add(Integer.parseInt(st.nextToken()));
			p.add(Integer.parseInt(st.nextToken()));
		}
		dfs(0, 0);
		System.out.println(max);

	}

	private static void dfs(int day, int price) {
		if(day >= n) {
			max = Math.max(max, price);
			return;
		}
		if (day + t.get(day) <= n) {
			dfs(day + t.get(day), price + p.get(day));
		}
		dfs(day + 1, price);
	}


}