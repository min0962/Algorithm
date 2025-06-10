import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int count = 0;
	static int[] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		arr = new int[n];

		backTracking(0);

		System.out.println(count);

	}

	private static void backTracking(int depth) {
		if(depth == n) {
			count++;
			return;
		}

		for (int i = 0; i < n; i++) {
			arr[depth] = i;

			if(valid(depth)) {
				backTracking(depth + 1);
			}

		}

	}

	private static boolean valid(int i) {
		for (int j = 0; j < i; j++) {
			if (arr[i] == arr[j]) {
				return false;
			} else if (Math.abs(i - j) == Math.abs(arr[i] - arr[j])) {
				return false;
			}
		}
		return true;
	}


}