import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class textfieldbuttons {
    public static void main(String[] args){
        JFrame frame = new JFrame("Test Project");
        JButton button = new JButton("Click me!");
        final JTextField tf = new JTextField();

        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button.setBounds(150,150,95,30);
        tf.setBounds(100, 200, 150, 20);
        frame.setSize(400, 400);
        frame.add(button); frame.add(tf);
        frame.setVisible(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf.setText("hi im noob");
            }
        });

        }

    }

