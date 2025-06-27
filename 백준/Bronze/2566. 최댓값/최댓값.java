import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int max = 0;
		int x = 0;
		int y = 0;

		for (int i = 1; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j < 10; j++) {
				int val = Integer.parseInt(st.nextToken());
				if (val >= max) {
					max = val;
					x = i;
					y = j;
				}
			}
		}

		System.out.println(max);
		System.out.println(x + " " + y);

	}
}