import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String arg[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 0; i < n; i++){
            HashSet<String> hs = new HashSet<>();
            String[] str = br.readLine().split("");
            hs.add(str[0]);
            String pre = str[0];
            boolean tf = true;
            for (int j = 1; j < str.length; j++) {
                String s = str[j];
                if(pre.equals(s)){
                    continue;
                }else if(hs.contains(s)){
                    tf = false;
                    break;
                }else{
                    pre = s;
                    hs.add(s);
                }
            }
            if(tf){
                cnt++;
            }
        }
        System.out.println(cnt);

    }
}



