import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class checkboxproj{
    public static void main(String[] args){
        SwingUtilities.invokeLater(()-> {
            checkboxtest();
        });
    }
    private static void checkboxtest(){
        JFrame frame = new JFrame("Checkbox Test");
        JLabel lab1 = new JLabel("Username: ");
        JTextField tf1 = new JTextField(10);
        JLabel lab2 = new JLabel("Password: ");
        JPasswordField pass = new JPasswordField(10);
        JButton button = new JButton("Sign in");
        JCheckBox check = new JCheckBox("Autofill Data.");

        check.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1){
                    tf1.setText("UserHohoho");
                    pass.setText("Hello");
                } else {
                    System.exit(0);
                }
            }
        });


        frame.add(lab1);
        frame.add(tf1);
        frame.add(lab2);
        frame.add(pass);
        frame.add(button);
        frame.add(check);

        frame.setLayout(new FlowLayout());
        frame.setSize(250, 250);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}