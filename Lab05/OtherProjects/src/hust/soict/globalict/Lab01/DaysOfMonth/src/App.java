import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        var monthFull = new ArrayList<String>(
                Arrays.asList("January", "February", "March", "April", "May", "June", "July",
                        "August",
                        "September", "October", "November", "December"));
        var monthAbbr = new ArrayList<String>(
                Arrays.asList("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"));
        var keyboard = new Scanner(System.in);
        System.out.print("Enter month: ");
        var month = keyboard.nextLine();
        if (month.length() == 4 && month.charAt(3) == '.') {
            month = month.substring(0, 3);
        }
        System.out.print("Enter year: ");
        var year = keyboard.nextInt();
        keyboard.close();

        int numberOfDays = -1;
        try {
            numberOfDays = getNumOfDays(Integer.parseInt(month), year);
        } catch (Exception e) {
            if (monthFull.indexOf(month) != -1) {
                numberOfDays = getNumOfDays(monthFull.indexOf(month) + 1, year);
            } else if (monthAbbr.indexOf(month) != -1) {
                numberOfDays = getNumOfDays(monthAbbr.indexOf(month) + 1, year);
            }
        }

        if (numberOfDays != -1) {
            System.out.println("Number of days in " + month + " " + year + " is " + numberOfDays);
        } else {
            System.out.println("Invalid month");
        }
    }

    public static int getNumOfDays(int numMonth, int year) {
        return switch (numMonth) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> {
                if (year % 400 == 0 || year % 4 != 0) {
                    yield 28;
                } else {
                    yield 29;
                }
            }
            default -> -1;
        };
    }

}
