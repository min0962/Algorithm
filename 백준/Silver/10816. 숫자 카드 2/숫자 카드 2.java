import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String arg[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(stk.nextToken());
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            } else{
                map.put(num,1);
            }
        }

        int m = Integer.parseInt(br.readLine());
        stk = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(stk.nextToken());
            if(map.containsKey(num)){
                sb.append(map.get(num)+" ");
            } else{
                sb.append(0+" ");
            }
        }
        System.out.println(sb);
    }
}



