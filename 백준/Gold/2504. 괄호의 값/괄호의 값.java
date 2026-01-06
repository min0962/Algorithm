import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        Stack<Character> stack = new Stack<>();
        int sum = 0;
        int temp = 1;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '(') {
                stack.add(c);
                temp *= 2;
            } else if (c == '[') {
                stack.add(c);
                temp *= 3;
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    sum = 0;
                    break;
                }
                if (str.charAt(i - 1) == '(') {
                    sum += temp;
                }
                stack.pop();
                temp /= 2;
            } else {
                if (stack.isEmpty() || stack.peek() != '[') {
                    sum = 0;
                    break;
                }
                if (str.charAt(i - 1) == '[') {
                    sum += temp;
                }
                stack.pop();
                temp /= 3;
            }
        }
        if (!stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(sum);
        }

    }

}

