import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static List<List<Node>> list;
	static int max = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		list = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			list.get(node1).add(new Node(node2, weight));
			list.get(node2).add(new Node(node1, weight));
		}

		for (int i = 1; i <= n; i++) {
			boolean[] visited = new boolean[n + 1];
			visited[i] = true;
			dfs(i, 0, visited);

		}
		System.out.println(max);

	}

	private static void dfs(int start, int distance, boolean[] visited) {
		max = Math.max(max, distance);

		for (Node node : list.get(start)) {
			if (!visited[node.getNode()]) {
				visited[node.getNode()] = true;
				dfs(node.getNode(), distance + node.getWeight(), visited);
				visited[node.getNode()] = false;
			}

		}

	}

}

class Node {
	private int node;
	private int weight;

	Node(int node, int weight) {
		this.node = node;
		this.weight = weight;
	}

	public int getNode() {
		return node;
	}

	public int getWeight() {
		return weight;
	}
}

