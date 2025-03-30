import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String arg[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++){
            String s = br.readLine();
            if(list.contains(s)){
                continue;
            }
            list.add(s);
        }

        list.sort((s1,s2)->{
            if(s1.length() != s2.length()){
                return s1.length() - s2.length();
            } else {
                return s1.compareTo(s2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s+"\n");
        }
        System.out.println(sb);

    }
}



