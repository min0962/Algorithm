import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int i = 0;
		int j = 1;
		int max = 0;
		int[] check = new int[100_001];
		check[arr[0]] = 1;
		int cnt = 1;
		while (j != n) {
			if (check[arr[j]] == k) {
				check[arr[i]]--;
				i++;
				cnt--;
			} else {
				check[arr[j]]++;
				j++;
				cnt++;
			}
			max = Math.max(max, cnt);
		}
		System.out.println(max);
	}
}