import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int[] xy = new int[n * m];

		int min = Integer.MAX_VALUE;
		int level = 0;

		for (int i = 0, k = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				xy[k] = Integer.parseInt(st.nextToken());
				k++;
			}
		}

		for (int floor = 0; floor <= 256; floor++) {
			int sec = 0;
			int block = b;
			boolean isTrue = true;
			for (int i = 0; i < xy.length; i++) {
				if (xy[i] > floor) {
					int h = xy[i] - floor;
					block += h;
					if((sec += h * 2) > min){
						isTrue = false;
						break;
					}
				} else if (xy[i] < floor) {
					int h = floor - xy[i];
					block -= h;
					if((sec += h) > min) {
						isTrue = false;
						break;
					}
				}
			}

			if (isTrue) {
				if (min >= sec && block >= 0) {
					min = sec;
					level = floor;
				}
			}

		}

		System.out.print(min + " " + level);

	}

}