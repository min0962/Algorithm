import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int flag = 0;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if (c == ' ') {
                if (flag == 0) {
                    sb2.append(sb1.reverse());
                    sb1.setLength(0);
                }
                sb2.append(c);
                continue;
            }

            if (c == '<') {
                flag = 1;
                sb2.append(sb1.reverse());
                sb2.append(c);
                sb1.setLength(0);
            } else if (c == '>') {
                flag = 0;
                sb2.append(c);
            } else if (flag == 1) {
                sb2.append(c);
            } else {
                sb1.append(c);
                if (i == line.length() - 1) {
                    sb2.append(sb1.reverse());
                }
            }
        }

        System.out.println(sb2);

    }


}

