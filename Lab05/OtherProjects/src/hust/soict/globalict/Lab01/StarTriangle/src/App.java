import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        var keyboard = new Scanner(System.in);
        var n = keyboard.nextInt();
        keyboard.close();
        for (int i = 0; i < n; i++) {
            String line = "";
            for (int j = n; j > i; j--) {
                line += " ";
            }
            for (int j = 0; j < i; j++) {
                line += "*";
            }
            line += "*";
            for (int j = 0; j < i; j++) {
                line += "*";
            }
            System.out.println(line);
        }
    }
}
