import javax.swing.JOptionPane;

public class CalculateSum {
    public static void main(String[] args) {
        String strNum1, strNum2;
        strNum1 = JOptionPane.showInputDialog("Input the first number: ");
        strNum2 = JOptionPane.showInputDialog("Input the second number: ");

        double sum = Double.parseDouble(strNum1) + Double.parseDouble(strNum2);
        double dif = Double.parseDouble(strNum1) - Double.parseDouble(strNum2);
        double product = Double.parseDouble(strNum1) * Double.parseDouble(strNum2);
        double quo = Double.parseDouble(strNum1) / Double.parseDouble(strNum2);

        JOptionPane.showMessageDialog(null,
                String.format("sum = %f\ndif = %f\nprod=%f\nquo=%f", sum, dif, product, quo));
        System.exit(0);
    }
}
