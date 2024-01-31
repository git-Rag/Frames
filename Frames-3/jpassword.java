import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class jpassword{
    public static void main(String[] args){
        SwingUtilities.invokeLater(()-> {
            passwordrip();
        });
    }
    private static void passwordrip(){
        JFrame frame = new JFrame("Password L");
        JLabel askuser = new JLabel("Username: ");
        JTextField user = new JTextField(10);
        JLabel askpass = new JLabel("Password: ");
        JPasswordField pass = new JPasswordField(10);
        JButton showpass = new JButton("Show Password");
        JLabel creds = new JLabel();
        showpass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String data = "Username: " + user.getText();
                data += ". Password: " + pass.getText();
                creds.setText(data);
            }
        });
        frame.add(askuser);
        frame.add(user);
        frame.add(askpass);
        frame.add(pass);
        frame.add(showpass);
        frame.add(creds);

        frame.setLayout(new FlowLayout());
        frame.setSize(250, 250);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}