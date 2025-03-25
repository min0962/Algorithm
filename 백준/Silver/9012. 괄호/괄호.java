import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < cnt; i++) {
            Stack<String> st = new Stack<>();
            String[] ps = br.readLine().split("");
            boolean tf = true;
            for (int j = 0; j < ps.length; j++) {
                if (ps[j].equals("(")) {
                    st.push(ps[j]);
                } else {
                    if (st.empty()) {
                        tf = false;
                        break;
                    } else {
                        st.pop();
                    }
                }
            }
            if (!st.empty()) {
                tf = false;
            }
            if (tf) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }


    }
}
