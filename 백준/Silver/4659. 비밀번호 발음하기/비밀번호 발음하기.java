import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {

            String str = br.readLine();
            String text = "";
            boolean flag = true;

            if (str.equals("end")) {
                break;
            }

            int vowelCount = 0;
            int repeatCount = 0;
            boolean tf = false;
            if (isVowel(str.charAt(0))) {
                vowelCount++;
                tf = true;
            }
            repeatCount++;

            char prev = str.charAt(0);

            for (int i = 1; i < str.length(); i++) {
                char now = str.charAt(i);
                if (now == prev) {
                    if (now == 'e' || now == 'o') {
                        repeatCount++;
                    } else {
                        flag = false;
                        break;
                    }
                } else {
                    if (isVowel(now)) {
                        if (tf) {
                            repeatCount++;
                        } else {
                            repeatCount = 1;
                            tf = true;
                        }
                        vowelCount++;
                    } else {
                        if (tf) {
                            repeatCount = 1;
                            tf = false;
                        } else {
                            repeatCount++;
                        }
                    }
                }
                if (repeatCount >= 3) {
                    flag = false;
                    break;
                }
                prev = now;

            }
            if (vowelCount < 1) {
                flag = false;
            }

            if (flag) {
                text = "is acceptable.";
            } else {
                text = "is not acceptable.";
            }

            sb.append("<").append(str).append("> ").append(text).append("\n");

        }

        System.out.println(sb);

    }

    private static boolean isVowel(char prev) {
        return prev == 'a' || prev == 'e' || prev == 'i' || prev == 'o' || prev == 'u';
    }

}