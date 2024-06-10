import javax.swing.JOptionPane;

public class SolvingEquation {
    public static void main(String[] args) {
        String[] values = { "First-degree with one variable", "Second-degree with one variable",
                "First-degree with two variables" };

        Object selected = JOptionPane.showInputDialog(null, "Which type of equations do you want to solve?",
                "Selection",
                JOptionPane.DEFAULT_OPTION, null, values, "0");
        if (selected != null) {// null if the user cancels.
            String selectedString = selected.toString();
            switch (selectedString) {
                case "First-degree with one variable":
                    solveFirstOrderOneVar();
                    break;
                case "Second-degree with one variable":
                    solveSecondOrderOneVar();
                    break;
                case "First-degree with two variables":
                    solveFirstOrderTwoVar();
                    break;
                default:
                    break;
            }
            System.exit(0);
        } else {
            System.out.println("User cancelled");
            System.exit(0);
        }
    }

    public static void solveFirstOrderOneVar() {
        String a = JOptionPane.showInputDialog("Enter a: ");
        String b = JOptionPane.showInputDialog("Enter b: ");
        if (Integer.parseInt(a) == 0) {
            if (Integer.parseInt(b) == 0) {
                JOptionPane.showMessageDialog(null, "x = 0", "Result", 0);
            } else {
                JOptionPane.showMessageDialog(null, "x = " + b, "Result", 0);
            }
        } else {
            Double result = -Double.parseDouble(b) / Double.parseDouble(a);
            JOptionPane.showMessageDialog(null, "x = " + result, "Result", 0);
        }
        System.exit(0);
    }

    public static void solveSecondOrderOneVar() {
        Double a = Double.parseDouble(JOptionPane.showInputDialog("Enter a: "));
        Double b = Double.parseDouble(JOptionPane.showInputDialog("Enter b: "));
        Double c = Double.parseDouble(JOptionPane.showInputDialog("Enter c: "));
        Double delta = b * b - 4 * a * c;
        if (delta > 0) {
            Double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            Double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            JOptionPane.showMessageDialog(null, String.format("x1 = %.3f\nx2 = %.3f", x1, x2), "result", 2);
        } else if (delta < 0) {
            JOptionPane.showMessageDialog(null, "NO Solution", "result", 0);
        } else {
            Double x = -b / (2 * a);
            JOptionPane.showMessageDialog(null, "x = " + x, "result", 1);
        }
        System.exit(0);
    }

    public static void solveFirstOrderTwoVar() {
        Double a11 = Double.parseDouble(JOptionPane.showInputDialog("Enter a11: "));
        Double a12 = Double.parseDouble(JOptionPane.showInputDialog("Enter a12: "));
        Double a21 = Double.parseDouble(JOptionPane.showInputDialog("Enter a21: "));
        Double a22 = Double.parseDouble(JOptionPane.showInputDialog("Enter a22: "));
        Double b1 = Double.parseDouble(JOptionPane.showInputDialog("Enter b1: "));
        Double b2 = Double.parseDouble(JOptionPane.showInputDialog("Enter b2: "));

        Double D1 = b1 * a21 - b2 * a11;
        Double D2 = a12 * a21 - a22 * a11;
        Double x2 = D1 / D2;
        Double x1 = (b1 - a12 * x2) / a11;

        if (a11 / a21 == a12 / a22) {
            if (a11 / a21 == b1 / b2) {
                JOptionPane.showMessageDialog(null, "Infinitely Solutions", "Result", 0);
            } else {
                JOptionPane.showMessageDialog(null, "No solution", "Result", 0);
            }
        } else {
            JOptionPane.showMessageDialog(null, String.format("x1 = %.3f\nx2 = %.3f", x1, x2), "Result", 0);
        }
        System.exit(0);
    }
}
