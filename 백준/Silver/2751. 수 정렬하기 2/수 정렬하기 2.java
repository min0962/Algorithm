import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String arg[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        List<Integer> ar = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            int num = Integer.parseInt(br.readLine());
            ar.add(num);
        }
        Collections.sort(ar);

        StringBuilder sb = new StringBuilder();
        for (Integer i : ar) {
            sb.append(i+"\n");
        }

        System.out.println(sb);

    }
}


