import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        List<Integer> list = new ArrayList<>();

        String[] split1 = line.split("-");

        for (String str : split1) {
            String[] split2 = str.split("\\+");
            int val = 0;
            for (String s : split2) {
                val += Integer.parseInt(s);
            }
            list.add(val);
        }

        int sum = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            sum -= list.get(i);
        }

        System.out.println(sum);
        
    }

}

