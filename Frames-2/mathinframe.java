import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mathinframe {
    public static void main(String[] args){
        SwingUtilities.invokeLater(()->{
            buttonsandStuff();
        });
    }
    private static void buttonsandStuff(){

        //frame
        JFrame frame = new JFrame("Addition");

        //button
        JButton button = new JButton("Add");

        //Textfields
        JTextField tf1 = new JTextField(10);
        JTextField tf2 = new JTextField(10);

        //Label
        JLabel result = new JLabel("Sum: ");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int num1 = Integer.parseInt(tf1.getText());
                    int num2 = Integer.parseInt(tf2.getText());
                    int resul = num1 + num2;

                    result.setText("Sum: " + resul);
                } catch(NumberFormatException ex){
                    result.setText("Invalid Data");
                }

            }
        });

        frame.add(tf1);
        frame.add(tf2);
        frame.add(button);
        frame.add(result);

        frame.setLayout(new FlowLayout());
        frame.setSize(300,150);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}