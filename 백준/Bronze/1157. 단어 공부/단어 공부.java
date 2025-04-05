import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String arg[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Map<Character,Integer> map = new HashMap<>();
        str = str.toUpperCase();
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(map.containsKey(c)){
                map.replace(c, map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }
        int max = 0;
        char maxChar = '?';
        boolean tf = false;
        for (Character c : map.keySet()) {
            int cnt = map.get(c);
            if(cnt > max){
                max = cnt;
                maxChar = c;
                tf = false;
            }else if(cnt == max){
                tf = true;
            }
        }
        if(tf){
            System.out.println('?');
        } else{
            System.out.println(maxChar);
        }


    }
}


