import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String arg[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{n,0});
        boolean[] v = new boolean[100001];
        v[n] = true;
        while(!q.isEmpty()){
            int subin[] = q.poll();
            int d = subin[0];
            int cnt = subin[1];
            if(d == m) {
                System.out.println(cnt);
                break;
            }
            if(d+1 <= 100000 && !v[d+1]){
                q.add(new int[]{d + 1, cnt + 1});
                v[d+1] = true;
            }
            if(d-1 >= 0 && !v[d-1] ){
                q.add(new int[]{d - 1, cnt + 1});
                v[d-1] = true;
            }
            if(d*2 <= 100000 && !v[d*2] ){
                q.add(new int[]{d * 2, cnt + 1});
                v[d*2] = true;
            }
        }
    }
}


