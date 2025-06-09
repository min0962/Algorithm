import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static StringBuilder sb;
	static ArrayList<Integer> list;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		list = new ArrayList<>();

		nm(1);

		System.out.println(sb);
	}
	private static void nm(int k){
		if(m == list.size()) {
			for(int i : list){
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= n; i++) {
			if(!list.contains(i)) {
				list.add(i);
				nm(i);
				list.remove(Integer.valueOf(i));
			}
		}

	}

}