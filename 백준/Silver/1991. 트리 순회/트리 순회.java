import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Node head = new Node("A", null, null);

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();

            insertNode(head, str, left, right);
        }

        preorder(head);
        System.out.println();
        inorder(head);
        System.out.println();
        postorder(head);

    }

    private static void insertNode(Node node, String str, String left, String right) {
        if (node.str.equals(str)) {
            node.left = left.equals(".") ? null : new Node(left, null, null);
            node.right = right.equals(".") ? null : new Node(right, null, null);
        } else {
            if (node.left != null) {
                insertNode(node.left, str, left, right);
            }
            if (node.right != null) {
                insertNode(node.right, str, left, right);
            }
        }

    }

    private static void preorder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.str);
        preorder(node.left);
        preorder(node.right);
    }

    private static void inorder(Node node) {
        if (node == null) {
            return;
        }

        inorder(node.left);
        System.out.print(node.str);
        inorder(node.right);
    }

    private static void postorder(Node node) {
        if (node == null) {
            return;
        }

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.str);
    }

}

class Node {

    Node left;
    String str;
    Node right;

    Node() {
    }

    Node(String str, Node left, Node right) {
        this.str = str;
        this.left = left;
        this.right = right;
    }

}