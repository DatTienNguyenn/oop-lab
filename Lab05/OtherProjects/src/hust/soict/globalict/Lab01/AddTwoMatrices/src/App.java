import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        var keyboard = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int row = keyboard.nextInt();
        System.out.print("Enter number of cols: ");
        int col = keyboard.nextInt();

        int[][] m1 = new int[row][col];
        int[][] m2 = new int[row][col];

        System.out.println("Enter the elements of the first matrix, separated by space and newline: ");
        keyboard.nextLine();
        for (int i = 0; i < row; i++) {
            var line = keyboard.nextLine();
            var arrStr = line.split(" ");
            for (int j = 0; j < col; j++) {
                m1[i][j] = Integer.parseInt(arrStr[j]);
            }
        }

        System.out.println("Enter the elements of the second matrix, separated by space and newline: ");
        for (int i = 0; i < row; i++) {
            var line = keyboard.nextLine();
            var arrStr = line.split(" ");
            for (int j = 0; j < col; j++) {
                m2[i][j] = Integer.parseInt(arrStr[j]);
            }
        }

        System.out.println("The sum of the two matrices is: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int sum = m1[i][j] + m2[i][j];
                System.out.print(sum + " ");
            }
            System.out.println();
        }

        keyboard.close();
    }
}
