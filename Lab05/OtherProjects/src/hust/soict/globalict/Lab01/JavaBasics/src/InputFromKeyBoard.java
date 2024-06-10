import java.util.Scanner;

public class InputFromKeyBoard {
    public static void main(String[] args) {
        var keyboard = new Scanner(System.in);
        System.out.println("What is your name?");
        var name = keyboard.nextLine();
        System.out.println("How old are you?");
        var age = keyboard.nextInt();
        System.out.println("How tall are you?");
        var height = keyboard.nextDouble();
        keyboard.close();
        System.out.println(String.format("Mrs/Mr. %s, %d years old. Your height is %.2f.", name, age, height));
    }
}
