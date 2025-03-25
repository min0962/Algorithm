import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Deque<String> q = new LinkedList<>();
        for (int i = 0; i < cnt; i++){
            StringTokenizer str = new StringTokenizer(br.readLine());
            String s1 = str.nextToken();
            if(s1.equals("push")){
                q.add(str.nextToken());
            } else if(s1.equals("pop")){
                if(q.isEmpty()){
                    sb.append("-1\n");
                }else{
                    sb.append(q.remove());
                    sb.append("\n");
                }
            } else if(s1.equals("size")){
                sb.append(q.size());
                sb.append("\n");

            } else if(s1.equals("empty")){
                if(q.isEmpty()){
                    sb.append("1\n");
                }else {
                    sb.append("0\n");
                }
            } else if(s1.equals("front")){
                if(q.isEmpty()){
                    sb.append("-1\n");
                }else {
                    sb.append(q.peek());
                    sb.append("\n");
                }
            } else if(s1.equals("back")){
                if(q.isEmpty()){
                    sb.append("-1\n");
                }else {
                    sb.append(q.peekLast());
                    sb.append("\n");
                }
            }

        }
        System.out.print(sb);
    }
}
