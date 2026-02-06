import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int val = Integer.parseInt(br.readLine());
		Node head = new Node(val);
		String str;
		while ((str = br.readLine()) != null) {
			val = Integer.parseInt(str);
			insertNode(head, val);
		}
		postOrder(head);
	}

	private static void postOrder(Node node) {
		if (node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.num);
	}

	private static void insertNode(Node node, int val) {
		if (node.num > val) {
			if (node.left == null) {
				node.left = new Node(val);
			} else {
				insertNode(node.left, val);
			}
		} else {
			if (node.right == null) {
				node.right = new Node(val);
			} else {
				insertNode(node.right, val);
			}
		}
	}

}

class Node {
	Node left, right;
	int num;

	Node(int val) {
		this.num = val;
		this.left = null;
		this.right = null;
	}

}


