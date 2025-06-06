import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n * 2 - 1; i++) {
			int k = i;
			if(n <= i){
				k = n - (i % n) - 2;
			}
			for (int j = 0; j < n - 1 - k; j++) {
				sb.append(" ");
			}
			for (int j = 0; j < k * 2 + 1; j++) {
				sb.append("*");
			}
			// for (int j = 0; j < n - 1 - k; j++) {
			// 	sb.append(" ");
			// }
			sb.append("\n");

		}

		System.out.println(sb);

	}
}