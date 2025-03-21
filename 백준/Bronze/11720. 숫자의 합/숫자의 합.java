import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input1 = scan.nextLine();
        String input2 = scan.nextLine();

        int sum = 0;
        for (int i = 0; i < input2.length(); i++){
            sum += Integer.parseInt(input2.charAt(i)+"");
        }
        System.out.println(sum);

    }
}