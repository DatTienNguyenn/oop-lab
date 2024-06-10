import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        var keyboard = new Scanner(System.in);
        System.out.println("Enter elements of array separated by space: ");
        String line = keyboard.nextLine();
        keyboard.close();
        var arrStr = line.split(" ");
        var arr = new ArrayList<Integer>();
        for (String item : arrStr) {
            arr.add(Integer.parseInt(item));
        }
        arr.sort((a, b) -> a - b);
        double sum = 0.0d;
        for (var num : arr) {
            sum += num;
        }
        System.out.println("Sum = " + sum);
        System.out.println("Avg = " + (sum / arr.size()));
    }
}
