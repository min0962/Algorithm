import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int max = 0;
    static int n, m;
    static List<List<Integer>> friendList;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        friendList = new ArrayList<>();
        list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            friendList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            friendList.get(a).add(b);
            friendList.get(b).add(a);
        }

        for (int i = 0; i < n; i++) {
            list.add(i);
            dfs(i, 0);
            list.remove(0);

            if (max == 4) {
                System.out.println(1);
                return;
            }
        }

        
        System.out.println(0);
        

    }

    private static void dfs(int v, int count) {
        if (count >= 4) {
            max = count;
            return;
        }

        for (int val : friendList.get(v)) {
            if (!list.contains(val)) {
                list.add(val);
                dfs(val, count + 1);
                list.remove(list.size() - 1);
            }
        }

    }

}
