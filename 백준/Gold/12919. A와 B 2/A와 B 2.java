import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String t = br.readLine();

        if (dfs1(s, t) || dfs2(s, t)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }


    }

    private static boolean dfs1(String s, String t) {

        if (s.length() == t.length()) {
            if (s.equals(t)) {
                return true;
            }
            return false;
        }

        StringBuilder sb = new StringBuilder(s).append("A");
        s = sb.toString();

        if (!t.contains(s) && !t.contains(sb.reverse())) {
            return false;
        }

        return dfs1(s, t) || dfs2(s, t);

    }

    private static boolean dfs2(String s, String t) {

        if (s.length() == t.length()) {
            if (s.equals(t)) {
                return true;
            }
            return false;
        }

        StringBuilder sb = new StringBuilder(s).append("B").reverse();
        s = sb.toString();

        if (!t.contains(s) && !t.contains(sb.reverse())) {
            return false;
        }

        return dfs1(s, t) || dfs2(s, t);

    }

}
