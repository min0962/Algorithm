import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String arg[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        StringTokenizer st3 = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st1.nextToken());
        int b = Integer.parseInt(st1.nextToken());

        int cnt1 = 0;
        int cnt2 = 0;

        HashSet<Integer> hsA= new HashSet<>();
        HashSet<Integer> hsB= new HashSet<>();

        for (int i = 0; i < a; i++){
            hsA.add(Integer.parseInt(st2.nextToken()));
        }
        for (int i = 0; i < b; i++){
            hsB.add(Integer.parseInt(st3.nextToken()));
        }

        for (Integer i : hsA) {
            if(!hsB.contains(i)){
                cnt1++;
            }
        }
        for (Integer i : hsB) {
            if(!hsA.contains(i)){
                cnt2++;
            }
        }

        System.out.println(cnt1 + cnt2);





    }
}



