import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String arg[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Point> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Point(x,y));
        }

        list.sort((p1, p2) -> {
            if(p1.x != p2.x){
                return p1.x - p2.x;
            }else{
                return p1.y - p2.y;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Point point : list) {
            sb.append(point.x + " " + point.y + "\n");
        }
        System.out.println(sb);

    }
    public static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}



