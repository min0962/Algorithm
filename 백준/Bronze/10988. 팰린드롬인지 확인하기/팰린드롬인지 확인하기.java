import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String st = br.readLine();

		for (int i = 0; i < st.length() / 2; i++) {
			if (st.charAt(i) != st.charAt(st.length() - i - 1)) {
				System.out.println(0);
				return;
			}
		}
		System.out.println(1);
	}
}