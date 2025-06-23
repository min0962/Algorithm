import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;

import javax.annotation.processing.Completion;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		HashSet<String> hs = new HashSet<>();
		for (int i = 0; i < n; i++) {
			hs.add(br.readLine());
		}
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			String s = br.readLine();
			if (hs.contains(s)) {
				list.add(s);
			}
		}

		Collections.sort(list);

		StringBuilder sb = new StringBuilder();
		sb.append(list.size()).append("\n");
		for (String s : list) {
			sb.append(s).append("\n");
		}

		System.out.println(sb);

	}

}