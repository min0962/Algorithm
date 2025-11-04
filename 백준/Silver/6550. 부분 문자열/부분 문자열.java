import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            String s = st.nextToken();
            String t = st.nextToken();
            int idx = 0;
            String result = "No";
            for (int i = 0; i < t.length(); i++) {
                if (s.charAt(idx) == t.charAt(i)) {
                    idx++;
                }
                if (idx == s.length()) {
                    result = "Yes";
                    break;
                }
            }
            sb.append(result).append("\n");
        }

        System.out.println(sb);

    }


}

