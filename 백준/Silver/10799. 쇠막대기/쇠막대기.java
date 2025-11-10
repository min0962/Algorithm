import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        Stack<Character> stack = new Stack<>();
        int total = 0;

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '(') {
                stack.add('(');
            } else {
                stack.pop();
                if (line.charAt(i - 1) == '(') {
                    total += stack.size();
                } else {
                    total++;
                }
            }

        }

        System.out.println(total);
        
    }


}

