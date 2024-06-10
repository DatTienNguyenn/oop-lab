import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        String[] values = { "I do", "I don't" };
        int option = JOptionPane.showConfirmDialog(null, "Do you want to change to first class ticket?", null,
                JOptionPane.YES_NO_OPTION);
        JOptionPane.showMessageDialog(null, "You've choosen: " + (option == JOptionPane.YES_OPTION ? "Yes" : "No"));
        System.exit(0);
    }
}
