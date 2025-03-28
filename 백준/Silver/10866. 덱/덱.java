import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Deque;

public class Main {
    public static void main(String arg[]) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        Deque dq = new LinkedList<>();

        for (int i = 0; i < cnt; i++){
            String str = br.readLine();
            StringTokenizer tk = new StringTokenizer(str);
            String s1 = tk.nextToken();
            if(s1.equals("push_front")){
                dq.addFirst(tk.nextToken());
                continue;
            }else if(s1.equals("push_back")){
                dq.addLast(tk.nextToken());
                continue;

            }else if(s1.equals("pop_front")){
                if(dq.isEmpty()){
                    sb.append("-1");
                }else {
                    sb.append(dq.pollFirst());
                }

            }else if(s1.equals("pop_back")){
                if(dq.isEmpty()){
                    sb.append("-1");
                }else {
                    sb.append(dq.pollLast());
                }

            }else if(s1.equals("size")){
                sb.append(dq.size());

            }else if(s1.equals("empty")){
                if(dq.isEmpty()){
                    sb.append("1");
                }else {
                    sb.append("0");
                }
            }else if(s1.equals("front")){
                if(dq.isEmpty()){
                    sb.append("-1");
                }else {
                    sb.append(dq.getFirst());
                }

            }else if(s1.equals("back")){
                if(dq.isEmpty()){
                    sb.append("-1");
                }else {
                    sb.append(dq.getLast());
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);


    }
}


